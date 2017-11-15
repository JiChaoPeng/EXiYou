package jcp.com.exiyou.base.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SweetDream on 2017/3/25.
 */

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mData;
    private List<String> mTitle;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> mData, List<String> mTitle) {
        super(fm);
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        if (mTitle != null) {
            this.mTitle = mTitle;
        } else {
            this.mTitle = new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
