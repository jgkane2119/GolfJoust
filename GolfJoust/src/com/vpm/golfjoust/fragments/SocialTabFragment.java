package com.vpm.golfjoust.fragments;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;
import com.vpm.golfjoust.R;


public class SocialTabFragment extends SherlockFragment {

	//for later use in viewpager
	CoursePagerAdapter mCoursePagerAdapter;
    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//set view
		View mView = inflater.inflate(R.layout.fragment_social_tab, container, false);
	   
		//make viewpager to switch b/w course views
		mViewPager = (ViewPager)mView.findViewById(R.id.social_pager);
	    mCoursePagerAdapter = new CoursePagerAdapter(getChildFragmentManager());
	    mViewPager.setAdapter(mCoursePagerAdapter);
	    
	    //set position to middle tab
	    mViewPager.setCurrentItem(1);

	    return mView;
	}


	public static class CoursePagerAdapter extends FragmentPagerAdapter {

        public CoursePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public SherlockFragment getItem(int position) {
            switch(position) {
            //these need revision
            case 0:
            	return new CourseHomeFragment();
			case 1:
            	return new CourseNearbyFragment();
			case 2:
            	return new CourseSearchFragment();
            default:
            	return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
            //make @strings for these
                case 0: return "KINGDOM".toUpperCase();
                case 1: return "FOURSOME".toUpperCase();
                case 2: return "CLUBHOUSE".toUpperCase();
            }
            return null;
        }
    }
	
}


