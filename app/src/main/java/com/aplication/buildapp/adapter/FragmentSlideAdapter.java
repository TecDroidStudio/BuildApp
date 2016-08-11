package com.aplication.buildapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yoshi on 8/11/16.
 */
public class FragmentSlideAdapter extends FragmentPagerAdapter{

    List<Fragment> listFragment;

    public FragmentSlideAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);

        this.listFragment = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
