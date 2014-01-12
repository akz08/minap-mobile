package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.MinapMobile;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.PatientDetailsActivity;
import com.ucl.appteam7.minapmobile.views.LoginView;

public class LoginFragment extends Fragment {

	private LoginView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		// If first run, show disclaimer/legal-ese stuff
		if(((MinapMobile) getActivity().getApplication()).getFirstRun()) {
			((MinapMobile) getActivity().getApplication()).setRunned();
			
			Toast.makeText(getActivity(), "first run!", Toast.LENGTH_LONG).show();
			
		} else {
			Toast.makeText(getActivity(), "NOT the first run!", Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (LoginView)View.inflate(getActivity(), R.layout.fragment_login, null);
		view.setViewListener(viewListener);
		return view;
	}

	// receive events from view
	private LoginView.ViewListener viewListener = new LoginView.ViewListener() {
		
		@Override
		public void onLogin() {
			// TODO: add in authentication stub
			// Link the login button to SIMPLY start PatientDetailsActivity
			Intent intent = new Intent(getActivity(), PatientDetailsActivity.class);
			startActivity(intent);
			
		}
	};
}
