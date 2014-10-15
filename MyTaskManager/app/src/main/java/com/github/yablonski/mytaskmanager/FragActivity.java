package com.github.yablonski.mytaskmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class FragActivity extends FragmentActivity {

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);
        mTabsAdapter.addTab(mTabHost.newTabSpec("simple").setIndicator("Android"), AndroidFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("contacts").setIndicator("IOs"), IOsFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("custom").setIndicator("Windows"), WindowsFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("throttle").setIndicator("DOS"), DOSFragment.class, null);

        if (savedInstanceState != null) {

            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));

        }
    }

}
