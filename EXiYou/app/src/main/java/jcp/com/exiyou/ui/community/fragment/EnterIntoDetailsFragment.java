package jcp.com.exiyou.ui.community.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseFragment;
import jcp.com.exiyou.base.util.LoadAnimation;
import jcp.com.exiyou.base.util.NetUtil;
import jcp.com.exiyou.ui.community.adapters.EnterIntoDetailsAdapter;
import jcp.com.exiyou.ui.community.bean.VisibilityEvent;
import jcp.com.exiyou.ui.community.bean.enterintodetails.DetailsDataBean;
import jcp.com.exiyou.ui.community.bean.enterintodetails.EntryBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoDetailsContract;
import jcp.com.exiyou.ui.community.model.EnterIntoDetailsModel;
import jcp.com.exiyou.ui.community.presenter.EnterIntoDetailsPresenter;


/**
 * Created by SweetDream on 2017/3/30.
 */
public class EnterIntoDetailsFragment extends BaseFragment<EnterIntoDetailsPresenter, EnterIntoDetailsModel> implements EnterIntoDetailsContract.View, SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener {

    private static final String TAG = EnterIntoDetailsFragment.class.getSimpleName();
    @BindView(R2.id.Enter_into_details_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R2.id.enter_into_details_list)
    ListView mListView;
    private EnterIntoDetailsAdapter mAdapter;
    private int page = 1;
    private View footer;
    private boolean isBottom;
    private int forum_id;
    private String forum_type;
    private int firstVisibleItem;
    private boolean isTop;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_enter_into_details;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);
    }

    @Override
    public void initView() {
        forum_id = getArguments().getInt("forum_id");
        forum_type = getArguments().getString("forum_type");

        footer = LayoutInflater.from(getActivity()).inflate(R.layout.recommend_footer, null);
        mAdapter = new EnterIntoDetailsAdapter(getActivity(), "forum_type", null, R.layout.enter_into_list_item_one, R.layout.enter_into_list_item_two);
        if (mListView.getFooterViewsCount() == 0) {
            mListView.addFooterView(footer);
        }
        mListView.setAdapter(mAdapter);

        mListView.setOnScrollListener(this);
        mRefresh.setColorSchemeResources(R.color.color_green_tab);
        mRefresh.setOnRefreshListener(this);

        // 发送网络请求数据
        getNetworkRes(forum_id, forum_type, page);

    }

    private void getNetworkRes(int id, String type, int page) {
        // 发送网络请求,获取得到的数据
        LoadAnimation.LoadingAnimation(footer, true);
        if (NetUtil.getNetState(getActivity())) {
            mPresenter.requestEnterIntoDetailsRes(id, type, page);
        } else {
            LoadAnimation.LoadingAnimation(footer, false);
            mRefresh.setRefreshing(false);
        }
    }

    @Override
    public void returnEnterIntoDetailsRes(DetailsDataBean detailsDataBean) {
        if (page == 1) {
            updateData(State.START, detailsDataBean.getEntry());
        } else {
            updateData(State.END, detailsDataBean.getEntry());
        }
        LoadAnimation.LoadingAnimation(footer, false);
        mRefresh.setRefreshing(false);
    }

    enum State {
        START, END
    }

    private void updateData(State state, List<EntryBean> mData) {
        switch (state) {
            case START:
                mAdapter.updateRes(mData);
                break;
            case END:
                mAdapter.addRes(mData);
                break;
        }
    }

    @Override
    public void OnStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {
        Log.e(TAG, "onError: " + errorInfo);
    }

    @Override
    public void onRefresh() {
        page = 1;
        getNetworkRes(forum_id, forum_type, ++page);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                if (isBottom) {
                    footer.setVisibility(View.VISIBLE);
                    LoadAnimation.LoadingAnimation(footer, true);
                    getNetworkRes(forum_id, forum_type, ++page);
                } else {
                    footer.setVisibility(View.GONE);
                }
                if (firstVisibleItem == 0) {
                    isTop = mListView.getChildAt(0).getTop() == 0 && mListView.getChildAt(0) != null;
                    }
                    VisibilityEvent event = new VisibilityEvent();
                    event.setFirstVisibleItem(firstVisibleItem);
                    event.setTop(isTop);
                    EventBus.getDefault().post(event);
                }
        }

        @Override
        public void onScroll (AbsListView view,int firstVisibleItem, int visibleItemCount,
        int totalItemCount){
            isBottom = firstVisibleItem + visibleItemCount == totalItemCount;
            this.firstVisibleItem = firstVisibleItem;
//        if (firstVisibleItem == 0) {
//            if (mListView.getChildAt(0).getTop() == 0 && mListView.getChildAt(0) != null) {
//                Log.e(TAG, "onScroll: this is top" );
//            }
//        }

        }

    }

