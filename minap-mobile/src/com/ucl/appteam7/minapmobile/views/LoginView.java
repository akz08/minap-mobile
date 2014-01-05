/**
 * MVC code architecture based primarily on Joshua MusselWhite's blog post:
 * 	Android Architecture: Part 10, The Activity Revisited
 * 	http://www.therealjoshua.com/2012/07/android-architecture-part-10-the-activity-revisited/
 * 
 * This Android MVC structure was chosen after considering variants of MVC, including MVP passive view. 
 */

package com.ucl.appteam7.minapmobile.views;

import com.ucl.appteam7.minapmobile.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LoginView extends RelativeLayout {

	private Button mLoginButton;
	
	// interface to send events from the view to the controller
	public static interface ViewListener {
		public void onLogin();
	}
	
	// listener reference for sending events
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	// constructor for xml layouts
	public LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// hook up objects from the xml layout
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();mLoginButton = (Button)findViewById(R.id.login_button);
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				viewListener.onLogin();
			}
		});
	}
}
