package com.ucl.appteam7.minapmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment {

	Button mLoginButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login, parent, false);
		
		// TODO add in authentication stub to mLoginButton onClick listener
		// Link the login button to SIMPLY start PatientDetailsActivity
		mLoginButton = (Button)view.findViewById(R.id.login_button);
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), PatientDetailsActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
}
