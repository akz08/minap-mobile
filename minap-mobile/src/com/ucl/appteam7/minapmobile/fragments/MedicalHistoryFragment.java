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
import android.widget.Spinner;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.AngiographyActivity;
import com.ucl.appteam7.minapmobile.activities.ExaminationsActivity;
import com.ucl.appteam7.minapmobile.model.Patient;
import com.ucl.appteam7.minapmobile.views.MedicalHistoryView;

public class MedicalHistoryFragment extends Fragment {
	
	// get the patient singleton
	Patient patient = Patient.get();
	
	private static final String DIALOG_ABOUT = "about";
	
	private Spinner mPreviousAmiSpinner;
	private Spinner mHypertensionSpinner;
	private Spinner mCerebroDiseaseSpinner;
	private Spinner mPreviousPCISpinner;
	private Spinner mSmokingStatusSpinner;
	private Spinner mDiabetesSpinner;
	
	private Spinner mPreviousAnginaSpinner;
	private Spinner mHypercholSpinner;
	private Spinner mAsthmaCopdSpinner;
	private Spinner mPreviousCabgSpinner;
	
	private Spinner mHeartFailureSpinner;
	private Spinner mPeripheralVascularDiseaseSpinner;
	private Spinner mChronicRenalFailureSpinner;
	private Spinner mFamilyHistoryOfChdSpinner;
	
	private MedicalHistoryView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (MedicalHistoryView)View.inflate(getActivity(), R.layout.fragment_medical_history, null);
		view.setViewListener(viewListener);
		
		// Populate spinners
		mPreviousAmiSpinner = (Spinner)view.findViewById(R.id.previous_ami_spinner);
		ArrayAdapter<CharSequence> amiAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.previous_ami_array, R.layout.multiline_spinner_item);
		amiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPreviousAmiSpinner.setAdapter(amiAdapter);
		
		mHypertensionSpinner = (Spinner)view.findViewById(R.id.hypertension_spinner);
		ArrayAdapter<CharSequence> hypertensionAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hypertension_array, R.layout.multiline_spinner_item);
		hypertensionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mHypertensionSpinner.setAdapter(hypertensionAdapter);
		
		mCerebroDiseaseSpinner = (Spinner)view.findViewById(R.id.cerebrovascular_disease_spinner);
		ArrayAdapter<CharSequence> cerebroAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.cerebrovascular_disease_array, R.layout.multiline_spinner_item);
		cerebroAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mCerebroDiseaseSpinner.setAdapter(cerebroAdapter);
		
		mPreviousPCISpinner = (Spinner)view.findViewById(R.id.previous_pci_spinner);
		ArrayAdapter<CharSequence> pciAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.previous_pci_array, R.layout.multiline_spinner_item);
		pciAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPreviousPCISpinner.setAdapter(pciAdapter);
		
		mSmokingStatusSpinner = (Spinner)view.findViewById(R.id.smoking_status_spinner);
		ArrayAdapter<CharSequence> smokingAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.smoking_status_array, R.layout.multiline_spinner_item);
		smokingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSmokingStatusSpinner.setAdapter(smokingAdapter);
		
		mDiabetesSpinner = (Spinner)view.findViewById(R.id.diabetes_spinner);
		ArrayAdapter<CharSequence> diabetesAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.diabetes_array, R.layout.multiline_spinner_item);
		diabetesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mDiabetesSpinner.setAdapter(diabetesAdapter);
		
		mPreviousAnginaSpinner = (Spinner)view.findViewById(R.id.previous_angina_spinner);
		ArrayAdapter<CharSequence> anginaAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.previous_angina_array, R.layout.multiline_spinner_item);
		anginaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPreviousAnginaSpinner.setAdapter(anginaAdapter);
		
		mHypercholSpinner = (Spinner)view.findViewById(R.id.hypercholesterolaemia_spinner);
		ArrayAdapter<CharSequence> hypercholAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hypercholesterolaemia_array, R.layout.multiline_spinner_item);
		hypercholAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mHypercholSpinner.setAdapter(hypercholAdapter);
		
		mAsthmaCopdSpinner = (Spinner)view.findViewById(R.id.asthma_copd_spinner);
		ArrayAdapter<CharSequence> asthmaAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.asthma_copd_array, R.layout.multiline_spinner_item);
		asthmaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mAsthmaCopdSpinner.setAdapter(asthmaAdapter);
		
		mPreviousCabgSpinner = (Spinner)view.findViewById(R.id.previous_cabg_spinner);
		ArrayAdapter<CharSequence> cabgAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.previous_cabg_array, R.layout.multiline_spinner_item);
		cabgAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPreviousCabgSpinner.setAdapter(cabgAdapter);
		
		mHeartFailureSpinner = (Spinner)view.findViewById(R.id.heart_failure_spinner);
		ArrayAdapter<CharSequence> heartAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.heart_failure_array, R.layout.multiline_spinner_item);
		heartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mHeartFailureSpinner.setAdapter(heartAdapter);
		
		mPeripheralVascularDiseaseSpinner = (Spinner)view.findViewById(R.id.peripheral_vascular_disease_spinner);
		ArrayAdapter<CharSequence> vascularAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.peripheral_vascular_disease_array, R.layout.multiline_spinner_item);
		vascularAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPeripheralVascularDiseaseSpinner.setAdapter(vascularAdapter);
		
		mChronicRenalFailureSpinner = (Spinner)view.findViewById(R.id.chronic_renal_failure_spinner);
		ArrayAdapter<CharSequence> renalAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.chronic_renal_failure_array, R.layout.multiline_spinner_item);
		renalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mChronicRenalFailureSpinner.setAdapter(renalAdapter);
		
		mFamilyHistoryOfChdSpinner = (Spinner)view.findViewById(R.id.family_history_of_chd_spinner);
		ArrayAdapter<CharSequence> chdAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.family_history_of_chd_array, R.layout.multiline_spinner_item);
		chdAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mFamilyHistoryOfChdSpinner.setAdapter(chdAdapter);
		
		// setup action bar 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private MedicalHistoryView.ViewListener viewListener = new MedicalHistoryView.ViewListener() {

		@Override
		public void showAboutPreviousAmi() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutHypertension() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutCerebroDisease() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPreviousPCI() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutSmokingStatus() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutDiabetes() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPreviousAngina() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutHyperchol() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutAsthmaCopd() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPreviousCabg() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutHeartFailure() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPeripheralVascularDisease() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutChronicRenalFailure() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutFamilyHistoryOfChd() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), ExaminationsActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), AngiographyActivity.class);
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
