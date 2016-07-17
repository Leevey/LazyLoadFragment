package com.ileevey.lazyload;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragments;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合

    public SimpleFragmentPagerAdapter(FragmentManager fm,
                                      List<Fragment> al,
                                      List<String> titleList) {
        super(fm);
        listFragments = al;
        mTitleList = titleList;
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

    /**
     * 防止频繁的销毁视图，设置ViewPager.setOffscreenPageLimit(2)<br/>
     * 或者重写PagerAdaper的destroyItem方法为空,<br/>
     * 即注释掉调用父类方法即可
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
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