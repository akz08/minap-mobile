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
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.testflightapp.lib.TestFlight;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.MedicalHistoryActivity;
import com.ucl.appteam7.minapmobile.model.Patient;
import com.ucl.appteam7.minapmobile.views.AngiographyView;

public class AngiographyFragment extends Fragment {
	private static final String CHECKPOINT_ANGIOGRAPHY = "Angiography";
	
	// get the patient singleton
	Patient patient = Patient.get();
	
	private static final String DIALOG_ABOUT = "about";
	private static final String DIALOG_DATE = "date";
	private static final String DIALOG_TIME = "time";
	
	private RadioGroup mAngiographyWasPerformedRadioGroup;
	
	private Spinner mDelayToAngiogramSpinner;
	private Spinner mInterventionalCentreSpinner;
	private Spinner mCoronaryInterventionSpinner;
	
	private TextView mDateTimeToReferralDateTextView;
	private TextView mDateTimeToReferralTimeTextView;
	private TextView mAngioDateTextView;
	private TextView mAngioTimeTextView;
	private TextView mDateFirstInterventionDateTextView;
	
	private ImageButton mAboutDateTimeToReferralButton;
	private ImageButton mAboutDelayToAngiogramButton;
	private ImageButton mAboutAngioDateTimeButton;
	private ImageButton mAboutInterventionalCentreButton;
	private ImageButton mAboutDateFirstInterventionButton;
	private ImageButton mAboutCoronaryInterventionButton;
	
	// ViewGroups to handle hidden fields
	private ViewGroup mContainerView;
	private ViewGroup mHiddenGroupAngiographyPerformed;
	private ViewGroup mHiddenGroupAngiographyPerformedContainerView;
	private ViewGroup mHiddenGroupAngiographyNotPerformed;
	
	private ViewGroup mHiddenGroupAngiographyPerformedThis0;
	private ViewGroup mHiddenGroupAngiographyPerformedThis1;
	
	private ViewGroup mHiddenGroupAngiographyPerformedAnother0;
	private ViewGroup mHiddenGroupAngiographyPerformedAnother1;
	
	private AngiographyView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		// TestFlight checkpoint
		TestFlight.passCheckpoint(CHECKPOINT_ANGIOGRAPHY);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (AngiographyView)View.inflate(getActivity(), R.layout.fragment_angiography, null);
		view.setViewListener(viewListener);
		
		// setup hidden views
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		mHiddenGroupAngiographyPerformedContainerView = (ViewGroup) view.findViewById(R.id.subcontainer);
		mHiddenGroupAngiographyPerformed = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_performed, mContainerView, false);
		mHiddenGroupAngiographyNotPerformed = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_not_performed, mContainerView, false);
		
		mHiddenGroupAngiographyPerformedThis0 = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_performed_this_hospital_0, mHiddenGroupAngiographyPerformedContainerView, false);
		mHiddenGroupAngiographyPerformedThis1 = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_performed_this_hospital_1, mHiddenGroupAngiographyPerformedContainerView, false);
		
		mHiddenGroupAngiographyPerformedAnother0 = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_performed_another_hospital_0, mHiddenGroupAngiographyPerformedContainerView, false);
		mHiddenGroupAngiographyPerformedAnother1 = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_performed_another_hospital_1, mHiddenGroupAngiographyPerformedContainerView, false);
		
		// wiring up action bar icon for ancestral navigation
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private AngiographyView.ViewListener viewListener = new AngiographyView.ViewListener() {
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), MedicalHistoryActivity.class);
			startActivity(intent);
			
		}

		@Override
		public void showAboutWarningAngiography() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(getString(R.string.title_warning_about_title), getString(R.string.title_warning_about_contents));
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAngiographyNotPerformed() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_was_angiography_performed));
			mContainerView.addView(mHiddenGroupAngiographyNotPerformed, viewIndex + 1);
			
		}

		@Override
		public void hideAngiographyNotPerformed() {
			mContainerView.removeView(mHiddenGroupAngiographyNotPerformed);
			
		}

		@Override
		public void showAngiographyPerformed() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_was_angiography_performed));
			mContainerView.addView(mHiddenGroupAngiographyPerformed, viewIndex + 1);
			
			// Hook up Date/Time of Referral textspinners
			mDateTimeToReferralDateTextView = (TextView)getView().findViewById(R.id.datetime_referral_investigation_intervention_date_textspinner);
			mDateTimeToReferralDateTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onDateReferral();
				}
			});
			
			mDateTimeToReferralTimeTextView = (TextView)getView().findViewById(R.id.datetime_referral_investigation_intervention_time_textspinner);
			mDateTimeToReferralTimeTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onTimeReferral();
				}
			});
			
			// Populate Delay to Angiogram Spinner
			mDelayToAngiogramSpinner = (Spinner)getView().findViewById(R.id.delay_to_performance_angiogram_spinner);
			ArrayAdapter<CharSequence> delayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.delay_to_performance_angiogram_array, R.layout.multiline_spinner_item);
			delayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mDelayToAngiogramSpinner.setAdapter(delayAdapter);
			
			// Wire up 'about' buttons for the 2 above items
			mAboutDateTimeToReferralButton = (ImageButton) view.findViewById(R.id.about_datetime_referral_investigation_intervention);
			mAboutDateTimeToReferralButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutDateTimeReferral();
				}
			});
			mAboutDelayToAngiogramButton = (ImageButton) view.findViewById(R.id.about_delay_to_performance_angiogram);
			mAboutDelayToAngiogramButton.setOnClickListener(new View.OnClickListener() {
					
				@Override
				public void onClick(View v) {
					showAboutDelayToAngiogram();
				}
			});
			
			// setup (2nd level) radio group that triggers layout display
			mAngiographyWasPerformedRadioGroup = (RadioGroup)view.findViewById(R.id.radio_group_angiography_performed);
			mAngiographyWasPerformedRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					switch(checkedId) {
					case R.id.radio_angiography_performed_1:
						hidePerformedThisHospital0();
						hidePerformedThisHospital1();
						hidePerformedAnotherHospital0();
						hidePerformedAnotherHospital1();
						
						showPerformedThisHospital0();
						showPerformedThisHospital1();
						break;
					case R.id.radio_angiography_performed_2:
						hidePerformedThisHospital0();
						hidePerformedThisHospital1();
						hidePerformedAnotherHospital0();
						hidePerformedAnotherHospital1();
						
						showPerformedThisHospital0();
						showPerformedThisHospital1();
						break;
					case R.id.radio_angiography_performed_3:
						hidePerformedThisHospital0();
						hidePerformedThisHospital1();
						hidePerformedAnotherHospital0();
						hidePerformedAnotherHospital1();
						
						showPerformedAnotherHospital0();
						showPerformedAnotherHospital1();
						break;
					case R.id.radio_angiography_performed_4:
						hidePerformedThisHospital0();
						hidePerformedThisHospital1();
						hidePerformedAnotherHospital0();
						hidePerformedAnotherHospital1();
						
						showPerformedAnotherHospital0();
						showPerformedAnotherHospital1();
						break;
					}
				}

			});
		}

		@Override
		public void hideAngiographyPerformed() {
			mContainerView.removeView(mHiddenGroupAngiographyPerformed);
			
		}

		@Override
		public void showPerformedThisHospital0() {
			// add the hidden view
			int viewIndex = mHiddenGroupAngiographyPerformed.indexOfChild(getView().findViewById(R.id.radio_group_angiography_performed));
			mHiddenGroupAngiographyPerformed.addView(mHiddenGroupAngiographyPerformedThis0, viewIndex + 1);
			
			// wire up angio date/time textspinner
			mAngioDateTextView = (TextView)getView().findViewById(R.id.angio_datetime_date_textspinner);
			mAngioDateTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onAngioDate();
				}
			});
			
			mAngioTimeTextView = (TextView)getView().findViewById(R.id.angio_datetime_time_textspinner);
			mAngioTimeTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onAngioTime();
				}
			});
			
			// wire up interventional centre spinner
			mInterventionalCentreSpinner = (Spinner)getView().findViewById(R.id.interventional_centre_spinner);
			ArrayAdapter<CharSequence> centreAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, R.layout.multiline_spinner_item);
			centreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mInterventionalCentreSpinner.setAdapter(centreAdapter);
			
			// wire up 'about' buttons
			mAboutAngioDateTimeButton = (ImageButton) view.findViewById(R.id.about_angio_datetime);
			mAboutAngioDateTimeButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.showAboutAngioDateTime();
				}
			});
			
			mAboutInterventionalCentreButton = (ImageButton) view.findViewById(R.id.about_interventional_centre);
			mAboutInterventionalCentreButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.showAboutInterventionalCentre();
				}
			});
		}

		@Override
		public void hidePerformedThisHospital0() {
			mHiddenGroupAngiographyPerformed.removeView(mHiddenGroupAngiographyPerformedThis0);
			
		}

		@Override
		public void showPerformedThisHospital1() {
			int viewIndex = mHiddenGroupAngiographyPerformed.indexOfChild(getView().findViewById(R.id.delay_to_performance_angiogram_spinner));
			mHiddenGroupAngiographyPerformed.addView(mHiddenGroupAngiographyPerformedThis1, viewIndex + 1);	
			
			// wire up date of first intervention/surgery textspinner
			mDateFirstInterventionDateTextView = (TextView)getView().findViewById(R.id.date_first_intervention_surgery_locally_date_textspinner);
			mDateFirstInterventionDateTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onDateFirstIntervention();
				}
			});
			
			// wire up coronary intervention spinner
			mCoronaryInterventionSpinner = (Spinner)getView().findViewById(R.id.coronary_intervention_spinner);
			ArrayAdapter<CharSequence> coronaryAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.coronary_intervention_array, R.layout.multiline_spinner_item);
			coronaryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mCoronaryInterventionSpinner.setAdapter(coronaryAdapter);
			
			// wire up 'about' buttons
			mAboutDateFirstInterventionButton = (ImageButton) view.findViewById(R.id.about_date_first_intervention_surgery_locally);
			mAboutDateFirstInterventionButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.showAboutDateFirstIntervention();
				}
			});
			
			mAboutCoronaryInterventionButton = (ImageButton) view.findViewById(R.id.about_coronary_intervention);
			mAboutCoronaryInterventionButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.showAboutCoronaryIntervention();
				}
			});
			
		}

		@Override
		public void hidePerformedThisHospital1() {
			mHiddenGroupAngiographyPerformed.removeView(mHiddenGroupAngiographyPerformedThis1);
			
		}

		@Override
		public void showPerformedAnotherHospital0() {
			int viewIndex = mHiddenGroupAngiographyPerformed.indexOfChild(getView().findViewById(R.id.radio_group_angiography_performed));
			mHiddenGroupAngiographyPerformed.addView(mHiddenGroupAngiographyPerformedAnother0, viewIndex + 1);
			
			// wire up interventional centre spinner
			mInterventionalCentreSpinner = (Spinner)getView().findViewById(R.id.interventional_centre_spinner);
			ArrayAdapter<CharSequence> centreAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, R.layout.multiline_spinner_item);
			centreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mInterventionalCentreSpinner.setAdapter(centreAdapter);
			
			// wire up 'about' button
			mAboutInterventionalCentreButton = (ImageButton) view.findViewById(R.id.about_interventional_centre);
			mAboutInterventionalCentreButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.showAboutInterventionalCentre();
				}
			});
		}

		@Override
		public void hidePerformedAnotherHospital0() {
			mHiddenGroupAngiographyPerformed.removeView(mHiddenGroupAngiographyPerformedAnother0);
			
		}

		@Override
		public void showPerformedAnotherHospital1() {
			int viewIndex = mHiddenGroupAngiographyPerformed.indexOfChild(getView().findViewById(R.id.delay_to_performance_angiogram_spinner));
			mHiddenGroupAngiographyPerformed.addView(mHiddenGroupAngiographyPerformedAnother1, viewIndex + 1);	
			
			// wire up coronary intervention spinner
			mCoronaryInterventionSpinner = (Spinner)getView().findViewById(R.id.coronary_intervention_spinner);
			ArrayAdapter<CharSequence> coronaryAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.coronary_intervention_array, R.layout.multiline_spinner_item);
			coronaryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mCoronaryInterventionSpinner.setAdapter(coronaryAdapter);
			
			// wire up about button
			mAboutCoronaryInterventionButton = (ImageButton) view.findViewById(R.id.about_coronary_intervention);
			mAboutCoronaryInterventionButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.showAboutCoronaryIntervention();
				}
			});
		}

		@Override
		public void hidePerformedAnotherHospital1() {
			mHiddenGroupAngiographyPerformed.removeView(mHiddenGroupAngiographyPerformedAnother1);
			
		}

		@Override
		public void showAboutAngioDateTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AngioDate.getNotesTitle() + " " + patient.AngioDate.getId(), patient.AngioDate.getNotes());
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void showAboutInterventionalCentre() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AngioCentreCode.getNotesTitle() + " " + patient.AngioCentreCode.getId(), patient.AngioCentreCode.getNotes());
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void showAboutDateTimeReferral() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.ReferralDate.getNotesTitle() + " " + patient.ReferralDate.getId(), patient.ReferralDate.getNotes());
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void showAboutDelayToAngiogram() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.AngioDelay.getNotesTitle() + " " + patient.AngioDelay.getId(), patient.AngioDelay.getNotes());
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void showAboutDateFirstIntervention() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.InterventionDate.getNotesTitle() + " " + patient.InterventionDate.getId(), patient.InterventionDate.getNotes());
			dialog.show(fm, DIALOG_ABOUT);				
		}

		@Override
		public void onDateReferral() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_referral_investigation_intervention));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void onTimeReferral() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_referral_investigation_intervention));
			dialog.show(fm, DIALOG_TIME);
			
		}

		@Override
		public void onAngioDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_angio_datetime));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void onAngioTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_angio_datetime));
			dialog.show(fm, DIALOG_TIME);
			
		}

		@Override
		public void onDateFirstIntervention() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_first_intervention_surgery_locally));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void showAboutCoronaryIntervention() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.CoronaryIntervention.getNotesTitle() + " " + patient.CoronaryIntervention.getId(), patient.CoronaryIntervention.getNotes());
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAboutAngiography() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.CoronaryAngiography.getNotesTitle() + " " + patient.CoronaryAngiography.getId(), patient.CoronaryAngiography.getNotes());
			dialog.show(fm, DIALOG_ABOUT);	
			
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
