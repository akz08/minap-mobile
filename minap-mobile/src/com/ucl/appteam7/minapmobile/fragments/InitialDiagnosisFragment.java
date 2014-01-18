package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.DemographicsAndAdmissionActivity;
import com.ucl.appteam7.minapmobile.model.Patient;
import com.ucl.appteam7.minapmobile.views.InitialDiagnosisView;

public class InitialDiagnosisFragment extends Fragment {
	
	// get the patient singleton
	Patient patient = Patient.get();
	
	private static final String DIALOG_ABOUT = "about";
	private static final String DIALOG_DATE = "date";
	
	private Spinner mNstemiSpinner;
	private Spinner mProcedureAtInterventionalHospitalSpinner;
	private Spinner mInterventionalCentreSpinner;
	
	private TextView mDateOfReturnTextView;
	
	private ImageButton mAboutHighRiskNstemiButton;
	private ImageButton mAboutProcedureAtInterventionalHospitalButton;
	private ImageButton mAboutInterventionalCentreButton;
	private ImageButton mAboutDateOfReturnButton;

	// ViewGroups to handle hidden fields
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
		
		// setup hidden views
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
			ArrayAdapter<CharSequence> nStemiAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.nstemi_array, R.layout.multiline_spinner_item);
			nStemiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mNstemiSpinner.setAdapter(nStemiAdapter);
			
			// Wire up 'about' buttons
			mAboutHighRiskNstemiButton = (ImageButton) view.findViewById(R.id.about_high_risk_nstemi);
			mAboutHighRiskNstemiButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutHighRiskNstemi();
				}
			});
		}

		@Override
		public void showAdmissionElsewhere() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_astemi_admission));
			mContainerView.addView(mHiddenGroupAdmissionElsewhere, viewIndex + 1);
			
			// Populate the Procedure at Interventional Hospital spinner
			mProcedureAtInterventionalHospitalSpinner = (Spinner)getView().findViewById(R.id.procedure_at_interventional_hospital_spinner);
			ArrayAdapter<CharSequence> procedureAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.procedure_at_interventional_hospital_array, R.layout.multiline_spinner_item);
			procedureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mProcedureAtInterventionalHospitalSpinner.setAdapter(procedureAdapter);
			
			// Populate the Interventional Centre spinner
			// NOTE: assumption that the contents are the same as hospitals_array
			mInterventionalCentreSpinner = (Spinner)getView().findViewById(R.id.interventional_centre_spinner);
			ArrayAdapter<CharSequence> centreAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, R.layout.multiline_spinner_item);
			centreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mInterventionalCentreSpinner.setAdapter(centreAdapter);
			
			// Wire up date TextView
			mDateOfReturnTextView = (TextView)getView().findViewById(R.id.date_of_return_textspinner);
			mDateOfReturnTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					onDateReturn();
				}
			});
			
			// Wire up 'about' buttons
			mAboutProcedureAtInterventionalHospitalButton = (ImageButton) view.findViewById(R.id.about_procedure_at_interventional_hospital);
			mAboutProcedureAtInterventionalHospitalButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutProcedureAtInterventionalHospital();
				}
			});
			
			mAboutInterventionalCentreButton = (ImageButton) view.findViewById(R.id.about_interventional_centre);
			mAboutInterventionalCentreButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutInterventionalCentre();
				}
			});
			
			mAboutDateOfReturnButton = (ImageButton) view.findViewById(R.id.about_date_of_return);
			mAboutDateOfReturnButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutDateOfReturn();
					
				}
			});
		}

		@Override
		public void hideAdmissionElsewhere() {
			mContainerView.removeView(mHiddenGroupAdmissionElsewhere);
		}

		@Override
		public void showAboutWorkingDiagnosis() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.InitialDiagnosis.getNotesTitle() + " " + patient.InitialDiagnosis.getId(), patient.InitialDiagnosis.getNotes());
			dialog.show(fm, DIALOG_ABOUT);
			
		}

		@Override
		public void showAboutAstemiAdmission() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);
			
		}

		@Override
		public void showAboutHighRiskNstemi() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
		}

		@Override
		public void showAboutProcedureAtInterventionalHospital() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void showAboutInterventionalCentre() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);				
		}
		
		@Override
		public void showAboutDateOfReturn() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void onDateReturn() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_date_of_return));
			dialog.show(fm, DIALOG_DATE);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), DemographicsAndAdmissionActivity.class);
			startActivity(intent);
		}
		
	};
	
	// inflate save button in action menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_value, menu);
		
	}
	
	// setup options menu actions
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
