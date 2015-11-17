package com.test.treinamentomobile.brasileirao_placar2015.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.test.treinamentomobile.brasileirao_placar2015.fragment.ListMatchesFragment_;
import com.test.treinamentomobile.brasileirao_placar2015.fragment.ListTeamsFragment_;

/**
 * Created by treinamentomobile on 11/16/15.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 2;
    private static final CharSequence[] TITLES = {"Times", "Partidas"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ListTeamsFragment_.builder().build();
            case 1:
                return ListMatchesFragment_.builder().build();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}