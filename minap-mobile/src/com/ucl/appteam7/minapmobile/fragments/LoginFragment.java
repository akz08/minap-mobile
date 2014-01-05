package com.ucl.appteam7.minapmobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.views.LoginView;

public class LoginFragment extends Fragment {

//	Button mLoginButton;
	private LoginView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		view = (LoginView)View.inflate(getActivity(), R.layout.fragment_login, null);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
//		View view = inflater.inflate(R.layout.fragment_login, parent, false);
		
		// TODO add in authentication stub to mLoginButton onClick listener
		// Link the login button to SIMPLY start PatientDetailsActivity
//		mLoginButton = (Button)view.findViewById(R.id.login_button);
//		mLoginButton.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View view) {
//				Intent intent = new Intent(getActivity(), PatientDetailsActivity.class);
//				startActivity(intent);
//			}
//		});
		return view;
	}
}
