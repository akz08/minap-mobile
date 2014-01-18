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
import android.widget.Toast;

import com.testflightapp.lib.TestFlight;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.InitialDiagnosisActivity;
import com.ucl.appteam7.minapmobile.activities.PrehospitalEventsActivity;
import com.ucl.appteam7.minapmobile.model.Patient;
import com.ucl.appteam7.minapmobile.views.DemographicsAndAdmissionView;

public class DemographicsAndAdmissionFragment extends Fragment {
	private static final String CHECKPOINT_DEMOGRAPHICS = "Demographics & Admission";
	
	// get the patient singleton
	Patient patient = Patient.get();
	
	private static final String DIALOG_ABOUT = "about";
	
	private Spinner mGenderSpinner;
	private Spinner mEthnicitySpinner;
	private Spinner mAdmissionMethodSpinner;
	private Spinner mAdmissionWardSpinner;
	private Spinner mAdmittingConsultantSpinner;
	private Spinner mReferralHospitalSpinner;
	private Spinner mPctCodeSpinner;
	private Spinner mAdminStatusSpinner;
	private Spinner mPlaceEcgSpinner;
	private Spinner mNhsVerificationSpinner;
	
	private ImageButton mAboutReferralHospitalButton;
	
	// ViewGroups to handle hidden fields
	private ViewGroup mContainerView;
	private ViewGroup mHiddenReferralHospital;
	
	private DemographicsAndAdmissionView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		// TestFlight checkpoint
		TestFlight.passCheckpoint(CHECKPOINT_DEMOGRAPHICS);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (DemographicsAndAdmissionView)View.inflate(getActivity(), R.layout.fragment_demographics_and_admission, null);
		view.setViewListener(viewListener);
		
		// Setup hidden views
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		mHiddenReferralHospital = (ViewGroup) inflater.inflate(R.layout.hidden_referral_hospital, mContainerView, false);
		
		// Populate the Gender spinner
		mGenderSpinner = (Spinner)view.findViewById(R.id.gender_spinner);
		ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.gender_array, R.layout.multiline_spinner_item);
		genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mGenderSpinner.setAdapter(genderAdapter);
		
		// Populate the Patient Ethnicity spinner
		mEthnicitySpinner = (Spinner)view.findViewById(R.id.patient_ethnicity_spinner);
		ArrayAdapter<CharSequence> ethnicityAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.patient_ethnicity_array, R.layout.multiline_spinner_item);
		ethnicityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mEthnicitySpinner.setAdapter(ethnicityAdapter);
		
		// Populate the Admission Method spinner
		mAdmissionMethodSpinner = (Spinner)view.findViewById(R.id.admission_method_spinner);
		ArrayAdapter<CharSequence> methodAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.admission_method_array, R.layout.multiline_spinner_item);
		methodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mAdmissionMethodSpinner.setAdapter(methodAdapter);
		
		// Populate the Admission Ward spinner
		mAdmissionWardSpinner = (Spinner)view.findViewById(R.id.admission_ward_spinner);
		ArrayAdapter<CharSequence> wardAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.admission_ward_array, R.layout.multiline_spinner_item);
		wardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mAdmissionWardSpinner.setAdapter(wardAdapter);
		
		// Populate the Admitting Consultant spinner
		mAdmittingConsultantSpinner = (Spinner)view.findViewById(R.id.admitting_consultant_spinner);
		ArrayAdapter<CharSequence> consultantAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.admitting_consultant_array, R.layout.multiline_spinner_item);
		consultantAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mAdmittingConsultantSpinner.setAdapter(consultantAdapter);
		
		// Populate the PCT Code spinner
		mPctCodeSpinner = (Spinner)view.findViewById(R.id.pct_code_spinner);
		ArrayAdapter<CharSequence> pctAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.pct_code_array, R.layout.multiline_spinner_item);
		pctAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPctCodeSpinner.setAdapter(pctAdapter);
		
		// Populate the Administrative Status spinner
		mAdminStatusSpinner = (Spinner)view.findViewById(R.id.admin_status_spinner);
		ArrayAdapter<CharSequence> adminAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.admin_status_array, R.layout.multiline_spinner_item);
		adminAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mAdminStatusSpinner.setAdapter(adminAdapter);
		
		// Populate the Place 1st ECG Performed spinner
		mPlaceEcgSpinner = (Spinner)view.findViewById(R.id.place_ecg_performed_spinner);
		ArrayAdapter<CharSequence> ecgAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.place_ecg_performed_array, R.layout.multiline_spinner_item);
		ecgAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPlaceEcgSpinner.setAdapter(ecgAdapter);
		
		// Populate the NHS Verification Status spinner
		mNhsVerificationSpinner = (Spinner)view.findViewById(R.id.nhs_verification_status_spinner);
		ArrayAdapter<CharSequence> nhsAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.nhs_verification_status_array, R.layout.multiline_spinner_item);
		nhsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mNhsVerificationSpinner.setAdapter(nhsAdapter);
		
		// setup action bar
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private DemographicsAndAdmissionView.ViewListener viewListener = new DemographicsAndAdmissionView.ViewListener() {

		@Override
		public void showReferralHospital() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.admitting_consultant_spinner));
			mContainerView.addView(mHiddenReferralHospital, viewIndex + 1);
			
			// Populate the Referral Hospital spinner
			mReferralHospitalSpinner = (Spinner)getView().findViewById(R.id.referral_hospital_spinner);
			ArrayAdapter<CharSequence> referralAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, R.layout.multiline_spinner_item);
			referralAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mReferralHospitalSpinner.setAdapter(referralAdapter);
			
			// Wire up 'about' buttons
			mAboutReferralHospitalButton = (ImageButton) view.findViewById(R.id.about_referral_hospital);
			mAboutReferralHospitalButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutReferralHospital();
				}
			});
		}

		@Override
		public void hideReferralHospital() {
			mContainerView.removeView(mHiddenReferralHospital);
			
		}

		@Override
		public void showAboutGender() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.Gender.getNotesTitle() + " " + patient.Gender.getId(), patient.Gender.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutEthnicity() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.Ethnicity.getNotesTitle() + " " + patient.Ethnicity.getId(), patient.Ethnicity.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutAdmissionMethod() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AdmissionMethod.getNotesTitle() + " " + patient.AdmissionMethod.getId(), patient.AdmissionMethod.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutAdmissionWard() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AdmissionWard.getNotesTitle() + " " + patient.AdmissionWard.getId(), patient.AdmissionWard.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutAdmittingConsultant() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AdmitConsul.getNotesTitle() + " " + patient.AdmitConsul.getId(), patient.AdmitConsul.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutReferralHospital() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.ReferralHospital.getNotesTitle() + " " + patient.ReferralHospital.getId(), patient.ReferralHospital.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}
		
		@Override
		public void showAboutGpPctCode() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.GPCode.getNotesTitle() + " " + patient.GPCode.getId(), patient.GPCode.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPostcode() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.PostCode.getNotesTitle() + " " + patient.PostCode.getId(), patient.PostCode.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutAdminStatus() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AdminStatus.getNotesTitle() + " " + patient.AdminStatus.getId(), patient.AdminStatus.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPlaceEcgPerformed() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.FirstECG.getNotesTitle() + " " + patient.FirstECG.getId(), patient.FirstECG.getNotes());
			dialog.show(fm, DIALOG_ABOUT);			
			
		}
		
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
