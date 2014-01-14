package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.InitialReperfusionActivity;
import com.ucl.appteam7.minapmobile.activities.MedicalHistoryActivity;
import com.ucl.appteam7.minapmobile.views.ExaminationsView;

public class ExaminationsFragment extends Fragment {
	
	private ExaminationsView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (ExaminationsView)View.inflate(getActivity(), R.layout.fragment_examinations, null);
		view.setViewListener(viewListener);
		
		// setup action bar 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private ExaminationsView.ViewListener viewListener = new ExaminationsView.ViewListener() {
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), InitialReperfusionActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), MedicalHistoryActivity.class);
			startActivity(intent);
			
		}
	};
	
	// inflate save button in action menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_value, menu);
		
	}
	
	// setup options menu save action
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_save:
				//TODO: save items on page to server
				Toast.makeText(getActivity(), R.string.saving, Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
