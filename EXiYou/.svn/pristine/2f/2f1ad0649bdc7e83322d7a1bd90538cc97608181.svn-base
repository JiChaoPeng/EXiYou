package jcp.com.exiyou.ui.community.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.adapters.BaseFragmentPagerAdapter;
import jcp.com.exiyou.base.base.BaseFragment;
import jcp.com.exiyou.ui.community.contract.CommunityContract;
import jcp.com.exiyou.ui.community.model.CommunityModel;
import jcp.com.exiyou.ui.community.presenter.CommunityPresenter;

/**
 * Created by SweetDream on 2017/3/25.
 */

public class CommunityFragment extends BaseFragment<CommunityPresenter, CommunityModel> implements CommunityContract.View {

    @BindView(R2.id.community_tab)
    TabLayout mTab;
    @BindView(R2.id.community_view_pager)
    ViewPager mViewPager;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.fragment_community;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);
    }

    @Override
    public void initView() {
        mPresenter.requestTitles(getActivity());
        mPresenter.requestFragments();

        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getChildFragmentManager(), fragments, titles);
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
    }

    @Override
    public void returnTitles(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public void returnFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public void OnStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }
}
