package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ucl.appteam7.minapmobile.R;

public class PrehospitalEventsView extends ScrollView {

	private ImageButton mAboutOnsetOfSymptomsButton;
	private ImageButton mAboutCallForHelpButton;
	private ImageButton mAboutArrivalFirstResponderButton;
	private ImageButton mAboutArrivalAmbulanceButton;
	private ImageButton mAboutAmbulanceTrustCodeButton;
	private ImageButton mAboutAmbulancePrfCadNumberButton;
	
	private TextView mOnsetOfSymptomsDateTextView;
	private TextView mOnsetOfSymptomsTimeTextView;
	private TextView mCallForHelpDateTextView;
	private TextView mCallForHelpTimeTextView;
	private TextView mArrivalFirstResponderDateTextView;
	private TextView mArrivalFirstResponderTimeTextView;
	private TextView mArrivalAmbulanceDateTextView;
	private TextView mArrivalAmbulanceTimeTextView;
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// about dialogs
		public void showAboutOnsetOfSymptoms();
		public void showAboutCallForHelpButton();
		public void showAboutArrivalFirstResponderButton();
		public void showAboutArrivalAmbulanceButton();
		public void showAboutAmbulanceTrustCodeButton();
		public void showAboutAmbulancePrfCadNumberButton();
		
		// date/time dialogs
		public void onOnsetDate();
		public void onOnsetTime();
		public void onCallDate();
		public void onCallTime();
		public void onArrivalResponderDate();
		public void onArrivalResponderTime();
		public void onArrivalAmbulanceDate();
		public void onArrivalAmbulanceTime();
		
		// navigation buttons
		public void previousPage();
		public void nextPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public PrehospitalEventsView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// Add on-click listeners to date and time TextViews
		mOnsetOfSymptomsDateTextView = (TextView)findViewById(R.id.onset_of_symptoms_date_textspinner);
		mOnsetOfSymptomsDateTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onOnsetDate();
			}
		});
		
		mOnsetOfSymptomsTimeTextView = (TextView)findViewById(R.id.onset_of_symptoms_time_textspinner);
		mOnsetOfSymptomsTimeTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onOnsetTime();
			}
		});
		
		mCallForHelpDateTextView = (TextView)findViewById(R.id.call_for_help_date_textspinner);
		mCallForHelpDateTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onCallDate();
			}
		});
		
		mCallForHelpTimeTextView = (TextView)findViewById(R.id.call_for_help_time_textspinner);
		mCallForHelpTimeTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onCallTime();
			}
		});
		
		mArrivalFirstResponderDateTextView = (TextView)findViewById(R.id.arrival_first_responder_date_textspinner);
		mArrivalFirstResponderDateTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onArrivalResponderDate();
			}
		});
		
		mArrivalFirstResponderTimeTextView = (TextView)findViewById(R.id.arrival_first_responder_time_textspinner);
		mArrivalFirstResponderTimeTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onArrivalResponderTime();
			}
		});
		
		mArrivalAmbulanceDateTextView = (TextView)findViewById(R.id.arrival_ambulance_date_textspinner);
		mArrivalAmbulanceDateTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onArrivalAmbulanceDate();
			}
		});
		
		mArrivalAmbulanceTimeTextView = (TextView)findViewById(R.id.arrival_ambulance_time_textspinner);
		mArrivalAmbulanceTimeTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.onArrivalAmbulanceTime();
			}
		});
		
		// Wire up 'about' information buttons
		mAboutOnsetOfSymptomsButton = (ImageButton)findViewById(R.id.about_onset_of_symptoms);
		mAboutOnsetOfSymptomsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutOnsetOfSymptoms();
				
			}
		});
		
		mAboutCallForHelpButton = (ImageButton)findViewById(R.id.about_call_for_help);
		mAboutCallForHelpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutCallForHelpButton();;
				
			}
		});
		
		mAboutArrivalFirstResponderButton = (ImageButton)findViewById(R.id.about_arrival_first_responder);
		mAboutArrivalFirstResponderButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutArrivalFirstResponderButton();
				
			}
		});
		
		mAboutArrivalAmbulanceButton = (ImageButton)findViewById(R.id.about_arrival_ambulance);
		mAboutArrivalAmbulanceButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutArrivalAmbulanceButton();
				
			}
		});
		
		mAboutAmbulanceTrustCodeButton = (ImageButton)findViewById(R.id.about_ambulance_trust_code);
		mAboutAmbulanceTrustCodeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAmbulanceTrustCodeButton();
				
			}
		});
		
		mAboutAmbulancePrfCadNumberButton = (ImageButton)findViewById(R.id.about_ambulance_prf_cad_number);
		mAboutAmbulancePrfCadNumberButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAmbulancePrfCadNumberButton();
				
			}
		});
		
		// wire up page navigation buttons
		mPreviousPage = (Button)findViewById(R.id.previous_page_button);
		mPreviousPage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.previousPage();
				
			}
		});
		
		mNextPage = (Button)findViewById(R.id.next_page_button);
		mNextPage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.nextPage();
				
			}
		});
	}	
}
