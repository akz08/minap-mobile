package com.ucl.appteam7.minapmobile.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.ucl.appteam7.minapmobile.MinapMobile;
import com.ucl.appteam7.minapmobile.R;

public class LegalDialogFragment extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		View view = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_legal, null);
		
		return new AlertDialog.Builder(getActivity())
						.setView(view)
						.setTitle(R.string.legal_label)
						.setPositiveButton(R.string.accept, new Dialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								// set preference file that indicates user has agreed
								((MinapMobile) getActivity().getApplication()).setAgreed();
								
							}
							
						})
						.setNegativeButton(R.string.close, new Dialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								// close the app
								getActivity().finish();
							}
							
						})
						.create();
	}
}
