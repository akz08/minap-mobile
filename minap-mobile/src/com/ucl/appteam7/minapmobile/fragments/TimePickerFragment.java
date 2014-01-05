package com.ucl.appteam7.minapmobile.fragments;

import com.ucl.appteam7.minapmobile.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class TimePickerFragment extends DialogFragment {
	public static final String EXTRA_TIME_TITLE =
			"com.ucl.appteam7.minapmobile.time.title";
	
	private String mTitle;
	
	// Initialize the fragment and accept a 'starting' title
		public static TimePickerFragment newInstance(String title) {
			Bundle args = new Bundle();
			args.putSerializable(EXTRA_TIME_TITLE, title);
			
			TimePickerFragment fragment = new TimePickerFragment();
			fragment.setArguments(args);
			
			return fragment;
		}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mTitle = (String)getArguments().getSerializable(EXTRA_TIME_TITLE);
		
		View view = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_time, null);
		
		return new AlertDialog.Builder(getActivity())
				.setView(view)
				.setTitle(mTitle)
				.setPositiveButton(android.R.string.ok, null)
				.create();
	}
}
