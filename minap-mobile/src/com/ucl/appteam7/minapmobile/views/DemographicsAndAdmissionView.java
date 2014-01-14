package com.ucl.appteam7.minapmobile.views;

import com.ucl.appteam7.minapmobile.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class DemographicsAndAdmissionView extends ScrollView {
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		// navigation buttons
		public void previousPage();
		public void nextPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public DemographicsAndAdmissionView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
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
