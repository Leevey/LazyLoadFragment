package com.ileevey.lazyload;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SimpleFragmentPagerAdapter  extends FragmentPagerAdapter {
    private List<Fragment> listFragments;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合

    public SimpleFragmentPagerAdapter(FragmentManager fm,
                                  List<Fragment> al,
                                  List<String> titleList) {
        super(fm);
        listFragments = al;
        mTitleList =  titleList;
    }

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);//页卡标题
    }
}