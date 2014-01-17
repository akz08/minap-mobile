package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.MedicalHistoryActivity;
import com.ucl.appteam7.minapmobile.views.AngiographyView;

public class AngiographyFragment extends Fragment {
	
	private static final String DIALOG_ABOUT = "about";
	
	// ViewGroups to handle hidden fields
	private ViewGroup mContainerView;
	private ViewGroup mHiddenGroupAngiographyPerformed;
	private ViewGroup mHiddenGroupAngiographyNotPerformed;
	
	private AngiographyView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (AngiographyView)View.inflate(getActivity(), R.layout.fragment_angiography, null);
		view.setViewListener(viewListener);
		
		// setup hidden views
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		mHiddenGroupAngiographyPerformed = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_performed, mContainerView, false);
		mHiddenGroupAngiographyNotPerformed = (ViewGroup) inflater.inflate(R.layout.hidden_group_angiography_not_performed, mContainerView, false);
		
		// wiring up action bar icon for ancestral navigation
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private AngiographyView.ViewListener viewListener = new AngiographyView.ViewListener() {
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), MedicalHistoryActivity.class);
			startActivity(intent);
			
		}

		@Override
		public void showAboutWarningAngiography() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAngiographyNotPerformed() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_angiography_performed));
			mContainerView.addView(mHiddenGroupAngiographyNotPerformed, viewIndex + 1);
			
		}

		@Override
		public void hideAngiographyNotPerformed() {
			mContainerView.removeView(mHiddenGroupAngiographyNotPerformed);
			
		}

		@Override
		public void showAngiographyPerformed() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_angiography_performed));
			mContainerView.addView(mHiddenGroupAngiographyPerformed, viewIndex + 1);
			
		}

		@Override
		public void hideAngiographyPerformed() {
			mContainerView.removeView(mHiddenGroupAngiographyPerformed);
			
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
