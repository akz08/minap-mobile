package com.ucl.appteam7.minapmobile.fragments;

import com.ucl.appteam7.minapmobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;

public class InitialDiagnosisFragment extends Fragment {
	
	Spinner mNstemiSpinner;
	RadioGroup mWorkingDiagnosisRadioGroup;
	private ViewGroup mContainerView;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_initial_diagnosis, parent, false);
		
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		final ViewGroup newView = (ViewGroup) inflater.inflate(R.layout.hidden_high_risk_nstemi, mContainerView, false);
		
		// general stuff 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		// Wire up radio buttons for nSTEMI
		mWorkingDiagnosisRadioGroup = (RadioGroup)view.findViewById(R.id.radio_group_working_diagnosis);
		mWorkingDiagnosisRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId) {
				case R.id.radio_working_diagnosis_1:
//					Log.d("radio", "1");
					mContainerView.removeView(newView);
					break;
				case R.id.radio_working_diagnosis_3:
//					Log.d("radio", "3");
					// find index of final radio group
					int debugViewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_astemi_admission));
					Log.d("initial index", Integer.toString(debugViewIndex));
					
					int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_working_diagnosis));
					mContainerView.addView(newView, viewIndex + 1);
					
					// update the index of final radio group
					debugViewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_astemi_admission));
					Log.d("initial index", Integer.toString(debugViewIndex));
					// Populate the nSTEMI spinner
					mNstemiSpinner = (Spinner)getView().findViewById(R.id.nstemi_spinner);
					ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.nstemi_array, android.R.layout.simple_spinner_item);
					adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					mNstemiSpinner.setAdapter(adapter);
					break;
				case R.id.radio_working_diagnosis_4:
					mContainerView.removeView(newView);
//					Log.d("radio", "4");
					break;
				case R.id.radio_working_diagnosis_5:
					mContainerView.removeView(newView);
//					Log.d("radio", "5");
					break;
				}
				
			}
		});
		
//		public void onClickedRadioWorkingDiagnosis(View view) {
//			boolean checked = ((RadioButton) view).isChecked();
//			
//			switch(view.getId()) {
//			case R.id.radio_working_diagnosis_1:
////				if (checked)
//					
//				break;
//			case R.id.radio_working_diagnosis_3:
//				if (checked)
//					view.findViewById(R.id.nstemi_label).setVisibility(View.GONE);
//				break;
//			case R.id.radio_working_diagnosis_4:
////				if (checked)
//					
//				break;
//			case R.id.radio_working_diagnosis_5:
////				if (checked)
//					
//				break;
//			}
//			
//		}
		
		return view;
	}
	
	// general stuff
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
