package jcp.com.exiyou.ui.community.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseFragment;
import jcp.com.exiyou.base.event.OnItemClickListener;
import jcp.com.exiyou.ui.community.adapters.LeftRecyclerAdapter;
import jcp.com.exiyou.ui.community.adapters.RightRecyclerAdapter;
import jcp.com.exiyou.ui.community.bean.enterinto.EnterIntoDataBean;
import jcp.com.exiyou.ui.community.bean.enterinto.ForumListBean;
import jcp.com.exiyou.ui.community.bean.enterinto.GroupBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoContract;
import jcp.com.exiyou.ui.community.model.EnterIntoModel;
import jcp.com.exiyou.ui.community.presenter.EnterIntoPresenter;

/**
 * Created by SweetDream on 2017/3/27.
 */

public class EnterIntoFragment extends BaseFragment<EnterIntoPresenter, EnterIntoModel> implements EnterIntoContract.View, OnItemClickListener {

    private static final String TAG = EnterIntoFragment.class.getSimpleName();
    @BindView(R2.id.enter_into_left)
    RecyclerView mLeftRecycler;
    @BindView(R2.id.enter_into_right)
    RecyclerView mRightRecycler;
    private LeftRecyclerAdapter mLeftAdapter;
    private List<ForumListBean> mData = new ArrayList<>();
    private RightRecyclerAdapter mRightAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_enter_into;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);
    }

    @Override
    public void initView() {
        mLeftAdapter = new LeftRecyclerAdapter(getActivity(), null, null, R.layout.enter_into_left_item);
        mLeftRecycler.setAdapter(mLeftAdapter);
        mRightAdapter = new RightRecyclerAdapter(getActivity(), null, null, R.layout.enter_into_right_item);
        mRightRecycler.setAdapter(mRightAdapter);

        mPresenter.requestEnterIntoRes();
        mLeftAdapter.setOnItemClickListener(this);
    }

    @Override
    public void returnEnterIntoRes(EnterIntoDataBean enterIntoDataBean) {
        mLeftAdapter.updateRes(enterIntoDataBean.getForum_list());
        mData.addAll(enterIntoDataBean.getForum_list());
    }

    @Override
    public void OnStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {
        Log.e(TAG, "onError: "+errorInfo );
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, int position) {
        if (position == 0) {
            GroupBean groupBean = new GroupBean();
            groupBean.setName("问答");
            groupBean.setTotal_threads("999999+");
            groupBean.setDescription("在这里让我们大家帮助大家");
            groupBean.setPhoto("drawable://");
            List<GroupBean> data = new ArrayList<>();
            data.add(groupBean);
            data.addAll(mData.get(0).getGroup());
            mRightAdapter.setIndex(position);
            mRightAdapter.updateRes(data);
        } else {
            mRightAdapter.setIndex(position);
            mRightAdapter.updateRes(mData.get(position).getGroup());
        }
    }
}
