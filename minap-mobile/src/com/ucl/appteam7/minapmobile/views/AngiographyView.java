package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;

import com.ucl.appteam7.minapmobile.R;

public class AngiographyView extends ScrollView {
	
	private RadioGroup mAngiographyPerformedRadioGroup;
	
	private ImageButton mAboutWarningAngiographyButton;
	
	private Button mPreviousPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// hidden values
		public void showAngiographyNotPerformed();
		public void hideAngiographyNotPerformed();
		
		public void showAngiographyPerformed();
		public void hideAngiographyPerformed();
		
		// methods for the nested layouts
		public void showPerformedThisHospital0();
		public void hidePerformedThisHospital0();
		
		public void showPerformedThisHospital1();
		public void hidePerformedThisHospital1();
		
		public void showPerformedAnotherHospital0();
		public void hidePerformedAnotherHospital0();
		
		public void showPerformedAnotherHospital1();
		public void hidePerformedAnotherHospital1();
		
		// about dialogs
		public void showAboutWarningAngiography();
		
		// navigation buttons
		public void previousPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public AngiographyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// wire up angiography performed? radio buttons
		mAngiographyPerformedRadioGroup = (RadioGroup)findViewById(R.id.radio_group_was_angiography_performed);
		mAngiographyPerformedRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId) {
				case R.id.radio_was_angiography_performed_yes:
					viewListener.hideAngiographyNotPerformed();
					viewListener.showAngiographyPerformed();
					break;
				case R.id.radio_was_angiography_performed_no:
					viewListener.hideAngiographyPerformed();
					viewListener.showAngiographyNotPerformed();
					break;
				}
				
			}
		});
		
		// wire up visible 'about' information button
		mAboutWarningAngiographyButton = (ImageButton)findViewById(R.id.about_warning_angiography);
		mAboutWarningAngiographyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutWarningAngiography();
				
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

	}
}
