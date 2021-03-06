package com.xinglefly.activity.control_ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;
import com.xinglefly.R;

/**
 * usage: ViewPagerIndicator library: ViewPagerIndicator
 * 
 * @author xinglefly
 * 
 */
public class ViewPagerIndicator extends FragmentActivity {

	private static final String[] CONTENT = new String[] { "Recent", "Artists",
			"Albums", "Songs", "Playlists", "Genres" };

	@Override
	protected void onCreate(Bundle saveinstanceBundle) {
		super.onCreate(saveinstanceBundle);
		setContentView(R.layout.viewpagerindicator);

		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);

	}

	class GoogleMusicAdapter extends FragmentPagerAdapter {
		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length].toUpperCase();
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}

}
