package jcp.com.exiyou.ui.shoppingmall.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseActivity;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchSecondMessageFragmentAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import jcp.com.exiyou.ui.shoppingmall.fragment.ShopSearchSecondHeaderFragment;
import jcp.com.exiyou.ui.shoppingmall.fragment.ShopSearchSecondMessageFragment;
import jcp.com.exiyou.ui.shoppingmall.model.ShopSearchSecondModel;
import jcp.com.exiyou.ui.shoppingmall.presenter.ShopSearchSecondPresenter;

public class ShopSearchSecondActicity extends BaseActivity<ShopSearchSecondPresenter,ShopSearchSecondModel> implements ShopContract.ShopSearchSecondView {

    private static final String TAG = ShopSearchSecondActicity.class.getSimpleName();

    @BindView(R2.id.shoppage_search_second_header_viewpager)
    ViewPager mHeaderViewPager;
    @BindView(R2.id.shoppage_search_second_messageviewpager)
    ViewPager mMessageViewPager;
//    @BindView(R2.id.shoppage_search_second_header_tablayout)
//    TabLayout mTabLayout;
    @OnClick(R2.id.shoppage_wv_details_back)
    public void wvBack(View v){
        this.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_search_second_acticity;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel,this);
    }


    ShopSearchSecondListBean data = new ShopSearchSecondListBean();
    @Override
    public void initView() {

        Intent intent = getIntent();
        String keyword = intent.getStringExtra("keyword");
        Log.e(TAG, "initView: " + keyword );
        mPresenter.getShopSearchSecondRes(keyword);
//
//        //自定义TabLayout
//        TabLayout.Tab tab = mTabLayout.newTab();
//        tab.setCustomView(R.layout.shoppage_search_second_tablayout_item);
//        mTabLayout.addTab(tab);
//        TabLayout.Tab tab1 = mTabLayout.newTab();
//        tab1.setCustomView(R.layout.shoppage_search_second_tablayout_item);
//        mTabLayout.addTab(tab1);
//        TabLayout.Tab tab2 = mTabLayout.newTab();
//        tab2.setCustomView(R.layout.shoppage_search_second_tablayout_item);
//        mTabLayout.addTab(tab2);
//        TabLayout.Tab tab3 = mTabLayout.newTab();
//        tab3.setCustomView(R.layout.shoppage_search_second_tablayout_item);
//        mTabLayout.addTab(tab3);
    }

    @Override
    public void returnShopSearchSecondData(ShopSearchSecondListBean data) {
//        Log.e(TAG, "111returnShopSearchSecondData: " + data.getData().getList().toString());

        List<Fragment> fragments = new ArrayList<>();
        ShopSearchSecondMessageFragment messageFragment = new ShopSearchSecondMessageFragment();
        messageFragment.setData(data);
        fragments.add(messageFragment);

        mMessageViewPager.setAdapter(new ShopSearchSecondMessageFragmentAdapter(getSupportFragmentManager(), fragments));

        List<Fragment> fragments2 = new ArrayList<>();
        ShopSearchSecondHeaderFragment fragment = new ShopSearchSecondHeaderFragment();
        fragment.setData(data);
        fragments2.add(fragment);
        mHeaderViewPager.setAdapter(new ShopSearchSecondMessageFragmentAdapter(getSupportFragmentManager(),fragments2));

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
