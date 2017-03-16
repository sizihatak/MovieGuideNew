package com.project.sizihatak.movieguidenew.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class FragmentAdapter extends FragmentStatePagerAdapter {


    private final int count;

    public FragmentAdapter(int count, FragmentManager fm) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }
}
