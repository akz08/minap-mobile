package com.ucl.appteam7.minapmobile;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationMapFragment extends Fragment {
	// stuff for temporary app drawer
	 private String[] mNavigationTitles;
	 private DrawerLayout mDrawerLayout;
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
//        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
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
	    
	    // if first session, animate the drawer in
	    if (mFirstSession) {
		    mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
		    mDrawerLayout.postDelayed(new Runnable() {
		        @Override
		        public void run() {
		            mDrawerLayout.openDrawer(Gravity.LEFT);
		        }
		    }, 600);
	    }
	}
}
