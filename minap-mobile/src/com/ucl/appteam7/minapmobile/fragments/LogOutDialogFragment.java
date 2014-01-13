package com.ucl.appteam7.minapmobile.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.LoginActivity;

public class LogOutDialogFragment extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		View view = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_log_out, null);
		
		return new AlertDialog.Builder(getActivity())
						.setView(view)
						.setTitle(R.string.log_out_label)
						.setIcon(R.drawable.ic_action_warning)
						.setPositiveButton(android.R.string.yes, new Dialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								// simply bring the user to the login page and show toast
								Intent intent = new Intent(getActivity(), LoginActivity.class);
				 				startActivity(intent);
				 				Toast.makeText(getActivity(), R.string.logging_out, Toast.LENGTH_SHORT).show();
							}
						})
						.setNegativeButton(android.R.string.no, null)
						.create();
	}
}
