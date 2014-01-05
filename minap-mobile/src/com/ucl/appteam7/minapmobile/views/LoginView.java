/**
 * MVC code architecture based primarily on Joshua MusselWhite's blog post:
 * 	Android Architecture: Part 10, The Activity Revisited
 * 	http://www.therealjoshua.com/2012/07/android-architecture-part-10-the-activity-revisited/
 * 
 * This Android MVC structure was chosen after considering variants of MVC, including MVP passive view. 
 */

package com.ucl.appteam7.minapmobile.views;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.PatientDetailsActivity;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LoginView extends RelativeLayout {

	private Button mLoginButton;
	
	public LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();mLoginButton = (Button)findViewById(R.id.login_button);
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO: call viewListener. open patient details - or something to that effect
			}
		});
	}
}
