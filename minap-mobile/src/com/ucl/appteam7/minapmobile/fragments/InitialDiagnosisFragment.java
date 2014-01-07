package com.ucl.appteam7.minapmobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.views.InitialDiagnosisView;

public class InitialDiagnosisFragment extends Fragment {
	
	Spinner mNstemiSpinner;
//	RadioGroup mWorkingDiagnosisRadioGroup;
	private ViewGroup mContainerView;
	private ViewGroup mHiddenHighRiskNstemi;
	private ViewGroup mHiddenGroupAdmissionElsewhere;
	
	private InitialDiagnosisView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (InitialDiagnosisView)View.inflate(getActivity(), R.layout.fragment_initial_diagnosis, null);
		view.setViewListener(viewListener);
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		mHiddenHighRiskNstemi = (ViewGroup) inflater.inflate(R.layout.hidden_high_risk_nstemi, mContainerView, false);
		mHiddenGroupAdmissionElsewhere = (ViewGroup) inflater.inflate(R.layout.hidden_group_admission_elsewhere, mContainerView, false);
		
		// setup action bar
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		
		return view;
	}
	
	private InitialDiagnosisView.ViewListener viewListener = new InitialDiagnosisView.ViewListener() {

		@Override
		public void hideAdmissionHighRisk() {
			mContainerView.removeView(mHiddenHighRiskNstemi);
		}

		@Override
		public void showAdmissionHighRisk() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_working_diagnosis));
			mContainerView.addView(mHiddenHighRiskNstemi, viewIndex + 1);
			
			// Populate the nSTEMI spinner
			mNstemiSpinner = (Spinner)getView().findViewById(R.id.nstemi_spinner);
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.nstemi_array, android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mNstemiSpinner.setAdapter(adapter);
		}

		@Override
		public void showAdmissionElsewhere() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_astemi_admission));
			mContainerView.addView(mHiddenGroupAdmissionElsewhere, viewIndex + 1);
		}

		@Override
		public void hideAdmissionElsewhere() {
			mContainerView.removeView(mHiddenGroupAdmissionElsewhere);
		}
		
	};
	
	// setup action bar
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(getActivity());
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	

}
