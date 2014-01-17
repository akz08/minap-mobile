package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.ucl.appteam7.minapmobile.R;

public class ExaminationsView extends ScrollView {

	private ImageButton mAboutSystolicBpButton;
	private ImageButton mAboutHeartRateOnAdmissionButton;
	private ImageButton mAboutKillipClassButton;
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// about dialogs
		public void showAboutSystolicBp();
		public void showAboutHeartRateOnAdmission();
		public void showAboutKillipClass();
		
		// navigation buttons
		public void previousPage();
		public void nextPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public ExaminationsView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// Wire up 'about' information buttons
		mAboutSystolicBpButton = (ImageButton)findViewById(R.id.about_systolic_bp);
		mAboutSystolicBpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutSystolicBp();
				
			}
		});
		
		mAboutHeartRateOnAdmissionButton = (ImageButton)findViewById(R.id.about_heart_rate_on_admission);
		mAboutHeartRateOnAdmissionButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutHeartRateOnAdmission();
				
			}
		});
		
		mAboutKillipClassButton = (ImageButton)findViewById(R.id.about_killip_class);
		mAboutKillipClassButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutKillipClass();
				
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
