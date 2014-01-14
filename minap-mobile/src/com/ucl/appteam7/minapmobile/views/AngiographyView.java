package com.ucl.appteam7.minapmobile.views;

import com.ucl.appteam7.minapmobile.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class AngiographyView extends ScrollView {
	
	private Button mPreviousPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
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
