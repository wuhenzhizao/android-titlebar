package org.wuhenzhizao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by liufei on 2017/12/1.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private String[] tabs = {"商品", "详情", "评价"};

    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        return new TabFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
