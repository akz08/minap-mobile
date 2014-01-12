package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.MinapMobile;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.PatientDetailsActivity;
import com.ucl.appteam7.minapmobile.views.LoginView;

public class LoginFragment extends Fragment {

	private static final String DIALOG_LEGAL = "legal";
	
	private LoginView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
//		if(((MinapMobile) getActivity().getApplication()).getFirstRun()) {
//			((MinapMobile) getActivity().getApplication()).setRunned();
		
		// If not yet agreed to disclaimer, show disclaimer/legal-ese stuff
		if(!((MinapMobile) getActivity().getApplication()).hasAgreed()) {
			
			FragmentManager fm = getActivity()
								.getSupportFragmentManager();
			LegalDialogFragment dialog = new LegalDialogFragment();
			dialog.show(fm, DIALOG_LEGAL);
			
		} else {
			// user has agreed, so do nothing - for now
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
