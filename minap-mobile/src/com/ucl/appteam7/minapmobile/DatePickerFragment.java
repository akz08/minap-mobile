/**
 * Code in this class based on the book (Ch. 12): 
 * "Android Programming: The Big Nerd Ranch Guide" (Publication Date: 28 Mar 2013)
 * by Bill Phillips and Brian Hardy 
 */

package com.ucl.appteam7.minapmobile;

import java.util.Date;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class DatePickerFragment extends DialogFragment {
	public static final String EXTRA_DATE_TITLE =
			"com.ucl.appteam7.minapmobile.date.title";
//	public static final String EXTRA_DATE =
//			"com.ucl.appteam7.minapmobile.date";
	
	private String mTitle;
	
	// Initialize the fragment and accept a 'starting' title ... and soon date
	public static DatePickerFragment newInstance(String title/*, Date date*/) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DATE_TITLE, title);
//		args.putSerializable(EXTRA_DATE, date);
		
		DatePickerFragment fragment = new DatePickerFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mTitle = (String)getArguments().getSerializable(EXTRA_DATE_TITLE);
		
		View view = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_date, null);
		
		return new AlertDialog.Builder(getActivity())
				.setView(view)
				.setTitle(mTitle)
				.setPositiveButton(android.R.string.ok, null)
				.create();
	}
}
