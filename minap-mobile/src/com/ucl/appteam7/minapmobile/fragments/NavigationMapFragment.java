package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.testflightapp.lib.TestFlight;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.AngiographyActivity;
import com.ucl.appteam7.minapmobile.activities.DemographicsAndAdmissionActivity;
import com.ucl.appteam7.minapmobile.activities.ExaminationsActivity;
import com.ucl.appteam7.minapmobile.activities.InitialDiagnosisActivity;
import com.ucl.appteam7.minapmobile.activities.InitialReperfusionActivity;
import com.ucl.appteam7.minapmobile.activities.MedicalHistoryActivity;
import com.ucl.appteam7.minapmobile.activities.PrehospitalEventsActivity;
import com.ucl.appteam7.minapmobile.views.NavigationMapView;


public class NavigationMapFragment extends Fragment {
	private static final String CHECKPOINT_NAVIGATION_MAP = "Navigation Map"; 
	
	private static final String DIALOG_NEW_PATIENT = "new patient";
	
	private NavigationMapView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		// TestFlight checkpoint
		TestFlight.passCheckpoint(CHECKPOINT_NAVIGATION_MAP);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
//		FrameLayout view = new FrameLayout(getActivity());

//		FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.TOP | Gravity.LEFT);
		
		
//		ImageView mapView = new NavigationMapView(getActivity());
//		mapView.setAdjustViewBounds(true);
//		mapView.setScaleType(ImageView.ScaleType.FIT_XY);
//		view.addView(mapView, fp);
//		view.setOnTouchListener(new PanAndZoomListener(view, mapView, Anchor.TOPLEFT));

		view = new NavigationMapView(getActivity());
		view.setViewListener(viewListener);
		
		return view;
	}
	
	private NavigationMapView.ViewListener viewListener = new NavigationMapView.ViewListener() {
		
		@Override
		public void gotoReperfusion() {
			Intent intent = new Intent(getActivity(), InitialReperfusionActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void gotoPrehospital() {
			Intent intent = new Intent(getActivity(), PrehospitalEventsActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void gotoMedicalHistory() {
			Intent intent = new Intent(getActivity(), MedicalHistoryActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void gotoInitialDiagnosis() {
			Intent intent = new Intent(getActivity(), InitialDiagnosisActivity.class);
			startActivity(intent);			
		}
		
		@Override
		public void gotoExaminations() {
			Intent intent = new Intent(getActivity(), ExaminationsActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void gotoDemographics() {
			Intent intent = new Intent(getActivity(), DemographicsAndAdmissionActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void gotoAngiography() {
			Intent intent = new Intent(getActivity(), AngiographyActivity.class);
			startActivity(intent);
			
		}
	};
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_navigation_map, menu);
		
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}

	
	@Override 
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_item_save_all:
			//TODO: save all pages to server
			Toast.makeText(getActivity(), R.string.saving_all, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menu_item_new_patient:
			// Open create new patient dialog
			FragmentManager fm = getActivity().getSupportFragmentManager();
			CreateNewPatientDialogFragment dialog = new CreateNewPatientDialogFragment();
			dialog.show(fm, DIALOG_NEW_PATIENT);
			return true;
		default:
			return super.onOptionsItemSelected(item);
	}
	}
	
}
