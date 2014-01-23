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
import com.ucl.appteam7.minapmobile.activities.PatientDetailsActivity;

public class CreateNewPatientDialogFragment extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		View view = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_new_patient, null);
		
		return new AlertDialog.Builder(getActivity())
						.setView(view)
						.setTitle(R.string.new_patient_label)
						.setIcon(R.drawable.ic_action_warning)
						.setPositiveButton(android.R.string.yes, new Dialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								// simply bring the user to the patient details page, and possibly nuke the local database (after sending to hypothetical server)
								Intent intent = new Intent(getActivity(), PatientDetailsActivity.class);
				 				startActivity(intent);
				 				Toast.makeText(getActivity(), R.string.new_patient_created, Toast.LENGTH_SHORT).show();
							}
						})
						.setNegativeButton(android.R.string.no, null)
						.create();
						
	}
}
