/**
 * All code in this class based on the book: 
 * "Android Programming: The Big Nerd Ranch Guide" (Publication Date: 28 Mar 2013)
 * by Bill Phillips and Brian Hardy 
 */

package com.ucl.appteam7.minapmobile.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;

public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
        }
    }
    
	// create options menu for logout, settings, help
 	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.fragment_general, menu);
		return true;
		
	}
 	
 	@Override
 	public boolean onOptionsItemSelected(MenuItem item) {
 		Intent intent;
 		
 		switch (item.getItemId()) {
 			case R.id.menu_item_log_out:
 				// Simple link to login page
 				intent = new Intent(this, LoginActivity.class);
 				startActivity(intent);
 				Toast.makeText(this, R.string.logging_out, Toast.LENGTH_SHORT).show();
 				return true;
 			case R.id.menu_item_help:
 				// search code taken from Google's Navigation Drawer Example
 	            intent = new Intent(Intent.ACTION_WEB_SEARCH);
 	            intent.putExtra(SearchManager.QUERY, "how to use an android app");
 	            // catch event that there's no activity to handle intent
 	            if (intent.resolveActivity(getPackageManager()) != null) {
 	                startActivity(intent);
 	            } else {
 	                Toast.makeText(this, R.string.browser_not_available, Toast.LENGTH_LONG).show();
 	            }
 				return true;
 			default:
 				return super.onOptionsItemSelected(item);
 		}
 	}
}