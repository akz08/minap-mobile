package com.ucl.appteam7.minapmobile.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;

import com.ucl.appteam7.minapmobile.R;

public class AboutDialogFragment extends DialogFragment {
	public static final String EXTRA_ABOUT_TITLE = 
			"com.ucl.appteam7.minapmobile.about.title";
	public static final String EXTRA_ABOUT_CONTENTS = 
			"com.ucl.appteam7.minapmobile.about.contents";
	
	private String mTitle;
	private String mContents;
	
	public static AboutDialogFragment newInstance(String title, String contents) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_ABOUT_TITLE, title);
		args.putSerializable(EXTRA_ABOUT_CONTENTS, contents);
		
		AboutDialogFragment fragment = new AboutDialogFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mTitle = (String)getArguments().getSerializable(EXTRA_ABOUT_TITLE);
		mContents = (String)getArguments().getSerializable(EXTRA_ABOUT_CONTENTS);
		
		View view = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_about, null);
		
		// set the about text content
		TextView contentsTextView = (TextView)view.findViewById(R.id.dialog_about_contents);
		contentsTextView.setText(mContents);
		
		return new AlertDialog.Builder(getActivity())
				.setView(view)
				.setTitle(mTitle)
				.setPositiveButton(R.string.close, null)
				.create();
	}
}
