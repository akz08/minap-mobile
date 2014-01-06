package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
//import android.widget.Spinner;
import android.widget.TextView;

import com.ucl.appteam7.minapmobile.R;

public class PatientDetailsView extends ScrollView {
	
//	private Spinner mHospitalSpinner;
	private Button mConfirmButton;
	private TextView mDateOfBirthTextView;
	private TextView mAdmissionDateTextView;
	private TextView mAdmissionTimeTextView;
	
	// interface to send events from the view to the controller
	public static interface ViewListener {
		public void onConfirm();
		public void onBirthDate();
		public void onAdmissionDate();
		public void onAdmissionTime();
	}
	
	// listener reference for sending events
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	// constructor for xml layouts
	public PatientDetailsView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// hook up objects from the xml layout
		@Override
		protected void onFinishInflate() {
			super.onFinishInflate();
			
			// Add on-click listeners to date and time TextViews
			mDateOfBirthTextView = (TextView)findViewById(R.id.date_of_birth);
			mDateOfBirthTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onBirthDate();
				}
			});
			
			mAdmissionDateTextView = (TextView)findViewById(R.id.admission_date);
			mAdmissionDateTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onAdmissionDate();
				}
			});
			
			mAdmissionTimeTextView = (TextView)findViewById(R.id.admission_time);
			mAdmissionTimeTextView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					viewListener.onAdmissionTime();
				}
			});
			
			// Populate the hospital name spinner
//			mHospitalSpinner = (Spinner)findViewById(R.id.hospitals_spinner);
//			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, android.R.layout.simple_spinner_item);
//			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//			mHospitalSpinner.setAdapter(adapter);
			
			mConfirmButton = (Button)findViewById(R.id.confirm_button);
			mConfirmButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					viewListener.onConfirm();
				}
			});
		}
}
