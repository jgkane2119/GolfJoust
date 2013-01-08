package com.vpm.golfjoust.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.vpm.golfjoust.R;
import com.vpm.golfjoust.fragments.CourseTabFragment;
import com.vpm.golfjoust.fragments.DealsTabFragment;
import com.vpm.golfjoust.fragments.ProfileTabFragment;
import com.vpm.golfjoust.fragments.SocialTabFragment;



public class MainActivity extends SherlockFragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionBar.newTab()
				.setIcon(R.drawable.social_group)
				.setText("SOCIAL")
				.setTabListener(new TabListener<SocialTabFragment>(
						this, "deals", SocialTabFragment.class));
		actionBar.addTab(tab);
		
		tab = actionBar.newTab()
				.setIcon(R.drawable.collections_labels)
				.setText("DEALS")
				.setTabListener(new TabListener<DealsTabFragment>(
						this, "deals", DealsTabFragment.class));
		actionBar.addTab(tab);
		
		tab = actionBar.newTab()
				.setIcon(R.drawable.explorebutton)
				.setText("COURSE")
				.setTabListener(new TabListener<CourseTabFragment>(
						this, "course", CourseTabFragment.class));
		actionBar.addTab(tab); 
		
		tab = actionBar.newTab()
				//collections sort by size drawable also nice
				.setIcon(R.drawable.homebutton)
				.setText("PROFILE")
				.setTabListener(new TabListener<ProfileTabFragment>(
						this, "deals", ProfileTabFragment.class));
		actionBar.addTab(tab);
	}
	

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public static class TabListener<T extends SherlockFragment> implements ActionBar.TabListener {
	    private SherlockFragment mFragment;
	    private final SherlockFragmentActivity mActivity;
	    private final String mTag;
	    private final Class<T> mClass;

	    /** Constructor used each time a new tab is created.
	      * @param activity  The host Activity, used to instantiate the fragment
	      * @param tag  The identifier tag for the fragment
	      * @param clz  The fragment's Class, used to instantiate the fragment
	      */
	    public TabListener(SherlockFragmentActivity activity, String tag, Class<T> clz) {
	        mActivity = activity;
	        mTag = tag;
	        mClass = clz;
	    }

	    /* The following are each of the ActionBar.TabListener callbacks */
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
	        // Check if the fragment is already initialized
	        if (mFragment == null) {
	            // If not, instantiate and add it to the activity
	            mFragment = (SherlockFragment) SherlockFragment.instantiate(mActivity, mClass.getName());
	            ft.add(android.R.id.content, mFragment, mTag);
	        } else {
	            // If it exists, simply attach it in order to show it
	            ft.attach(mFragment);
	        }
	    }

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	        if (mFragment != null) {
	            // Detach the fragment, because another one is being attached
	            ft.detach(mFragment);
	        }
	    }

	    public void onTabReselected(Tab tab, FragmentTransaction ft) {
	        // User selected the already selected tab. Usually do nothing.
	    }

	}
}