package com.ucl.appteam7.minapmobile.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.testflightapp.lib.TestFlight;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.views.NavigationMapView;
import com.ucl.appteam7.minapmobile.views.PanAndZoomListener;
import com.ucl.appteam7.minapmobile.views.PanAndZoomListener.Anchor;


public class NavigationMapFragment extends Fragment {
	private static final String CHECKPOINT_NAVIGATION_MAP = "Navigation Map"; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		// TestFlight checkpoint
		TestFlight.passCheckpoint(CHECKPOINT_NAVIGATION_MAP);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
//		FrameLayout view = new FrameLayout(getActivity());

//		FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.TOP | Gravity.LEFT);
		
		
//		ImageView mapView = new NavigationMapView(getActivity());
//		mapView.setAdjustViewBounds(true);
//		mapView.setScaleType(ImageView.ScaleType.FIT_XY);
//		view.addView(mapView, fp);
//		view.setOnTouchListener(new PanAndZoomListener(view, mapView, Anchor.TOPLEFT));

		return new NavigationMapView(getActivity());
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_navigation_map, menu);
		
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}

	
	@Override 
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_item_save_all:
			//TODO: save all pages to server
			Toast.makeText(getActivity(), R.string.saving_all, Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
	}
	}
	
}
