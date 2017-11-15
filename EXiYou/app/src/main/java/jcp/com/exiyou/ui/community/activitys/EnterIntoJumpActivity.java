package jcp.com.exiyou.ui.community.activitys;


import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.adapters.BaseFragmentPagerAdapter;
import jcp.com.exiyou.base.base.BaseActivity;
import jcp.com.exiyou.ui.community.bean.VisibilityEvent;
import jcp.com.exiyou.ui.community.bean.enterintotitle.TitleDataBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoTitleContract;
import jcp.com.exiyou.ui.community.fragment.EnterIntoDetailsFragment;
import jcp.com.exiyou.ui.community.model.EnterIntoTitleModel;
import jcp.com.exiyou.ui.community.presenter.EnterIntoTitlePresenter;

public class EnterIntoJumpActivity extends BaseActivity<EnterIntoTitlePresenter, EnterIntoTitleModel> implements EnterIntoTitleContract.View {

    private static final String TAG = EnterIntoJumpActivity.class.getSimpleName();
    @BindView(R2.id.activity_enter_into_jump_viewPager)
    ViewPager mViewPager;
    @BindView(R2.id.activity_enter_into_jump_tab)
    TabLayout mTab;
    @BindView(R2.id.activity_enter_into_jump_photo)
    ImageView mPhoto;
    @BindView(R2.id.activity_enter_into_jump_name)
    TextView mName;
    @BindView(R2.id.activity_enter_into_jump_toolBar_name)
    TextView mToolBarName;
    @BindView(R2.id.activity_enter_into_jump_description)
    TextView mDescription;
    @BindView(R2.id.activity_enter_into_jump_total_threads)
    TextView mTotalThreads;
    @BindView(R2.id.activity_enter_into_jump_layout)
    RelativeLayout layout;
    private int fid;

    @Override
    public int getLayoutId() {
        return R.layout.activity_enter_into_jump;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);
    }

    @Override
    public void initView() {
        fid = getIntent().getIntExtra("fid", 0);
        mPresenter.requestEnterIntoTitleRes(fid);

    }

    @OnClick(value = {R2.id.activity_enter_into_jump_back, R2.id.activity_enter_into_jump_search})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_enter_into_jump_back:
                finish();
                break;
            case R.id.activity_enter_into_jump_search:

                break;
        }

    }

    @Override
    public void returnEnterIntoTitleRes(TitleDataBean itemDataBean) {

        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < itemDataBean.getTypes().size(); i++) {
            EnterIntoDetailsFragment fragment = new EnterIntoDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("forum_id", fid);
            bundle.putString("forum_type", itemDataBean.getTypes().get(i).getForum_type());
            fragment.setArguments(bundle);
            fragments.add(fragment);
            titles.add(itemDataBean.getTypes().get(i).getName());
        }

        mViewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        mTab.setupWithViewPager(mViewPager);

        initTitle(itemDataBean);
    }

    private void initTitle(TitleDataBean itemDataBean) {
        mToolBarName.setText(itemDataBean.getName());
        mName.setText(itemDataBean.getName());
        mDescription.setText(itemDataBean.getDescription());
        mTotalThreads.setText(itemDataBean.getTotal_threads() + "个帖子");
        Picasso.with(this).load(itemDataBean.getPhoto()).into(mPhoto);
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

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onEvent(VisibilityEvent event) {

        if (event.getFirstVisibleItem() == 0) {
            if (event.isTop()) {
                layout.setVisibility(View.VISIBLE);
            }
        } else {
            layout.setVisibility(View.GONE);
        }
    }

}
