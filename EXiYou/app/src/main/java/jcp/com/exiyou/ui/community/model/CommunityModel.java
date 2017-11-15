package jcp.com.exiyou.ui.community.model;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.ui.community.contract.CommunityContract;
import jcp.com.exiyou.ui.community.fragment.EnterIntoFragment;
import jcp.com.exiyou.ui.community.fragment.RecommendFragment;

/**
 * Created by SweetDream on 2017/3/27.
 */

public class CommunityModel implements CommunityContract.Model {

    @Override
    public List<String> getTitles(Context context) {
        List<String> titles = new ArrayList<>();
        titles.add(context.getResources().getString(R.string.recommend));
        titles.add(context.getResources().getString(R.string.enter_into));
        return titles;
    }

    @Override
    public List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new EnterIntoFragment());
        return fragments;
    }
}
