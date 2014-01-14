package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.InitialDiagnosisActivity;
import com.ucl.appteam7.minapmobile.activities.PrehospitalEventsActivity;
import com.ucl.appteam7.minapmobile.views.DemographicsAndAdmissionView;

public class DemographicsAndAdmissionFragment extends Fragment {
	
	// ViewGroups to handle hidden fields
	private ViewGroup mContainerView;
	
	private DemographicsAndAdmissionView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (DemographicsAndAdmissionView)View.inflate(getActivity(), R.layout.fragment_demographics_and_admission, null);
		view.setViewListener(viewListener);
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		
		// setup action bar
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private DemographicsAndAdmissionView.ViewListener viewListener = new DemographicsAndAdmissionView.ViewListener() {
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), InitialDiagnosisActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), PrehospitalEventsActivity.class);
			startActivity(intent);
			
		}
	};

	// inflate save button in action menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_value, menu);
		
	}
	
	// setup options menu save action
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_save:
				//TODO: save items on page to server
				Toast.makeText(getActivity(), R.string.saving, Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
