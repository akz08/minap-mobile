package com.ucl.appteam7.minapmobile.fragments;

import com.ucl.appteam7.minapmobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class PrehospitalEventsFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_prehospital_events, parent, false);
		
		// general stuff 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}

}
