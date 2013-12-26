package com.ucl.appteam7.minapmobile;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationMapFragment extends Fragment {
	// stuff for temporary app drawer
	private static final int DRAWER_OPEN_DELAY = 600;
	
	 private String[] mNavigationTitles;
	 private DrawerLayout mDrawerLayout;
	 private ActionBarDrawerToggle mDrawerToggle;
	 private ListView mDrawerList;
	 private boolean mFirstSession = true;
	 

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_navigation_map, parent, false);
		
		// setup navigation drawer
		mNavigationTitles = getResources().getStringArray(R.array.navigation_array);
        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) view.findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.drawer_list_item, mNavigationTitles));
        
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        
        // link interactions of drawer and action bar icon
        mDrawerToggle = new ActionBarDrawerToggle(
        		getActivity(), 
        		mDrawerLayout,
        		R.drawable.ic_drawer, 
        		R.string.drawer_open, 
        		R.string.drawer_close) {
        	
        	// called when drawer completely closed
        	public void onDrawerClosed(View view) {
        		
        	}
        	// called when drawer completely opened
        	public void onDrawerOpened(View view) {
        		
        	}
        };
        
        // enable app icon to act as action to toggle nav drawer
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().getActionBar().setHomeButtonEnabled(true);
        getActivity().getActionBar().setDisplayShowHomeEnabled(true);
        
        // set drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        

		
		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_navigation_map, menu);
		
	}
	
	@Override
	public void onResume() {
	    super.onResume(); 
	    mDrawerToggle.syncState();
	    
	    // if first session, animate the drawer in
	    if (mFirstSession) {
		    mDrawerLayout.postDelayed(new Runnable() {
		        @Override
		        public void run() {
		            mDrawerLayout.openDrawer(Gravity.LEFT);
		        }
		    }, DRAWER_OPEN_DELAY);
		    
		    // TODO set mFirstSession to be false as part of the saved bundle arguments 
	    }
	}
	

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    mDrawerToggle.onConfigurationChanged(newConfig);
	}

	
	@Override 
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		};
		
		return super.onOptionsItemSelected(item);
	}
	
	
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position, long id) {
			selectItem(position);
		}
	}

	
	/**
	 * Called by DrawerItemClickListener when drawer item is clicked
	 * 
	 * @param position position of item in drawer's list
	 */
	private void selectItem(int position) {
		// just close the drawer for now
		mDrawerLayout.closeDrawer(mDrawerList);
	}
}
