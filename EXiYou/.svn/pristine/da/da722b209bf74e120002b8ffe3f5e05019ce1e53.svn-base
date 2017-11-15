package jcp.com.exiyou.ui.community.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseFragment;
import jcp.com.exiyou.base.util.LoadAnimation;
import jcp.com.exiyou.base.util.NetUtil;
import jcp.com.exiyou.ui.community.adapters.RecommendListAdapter;
import jcp.com.exiyou.ui.community.bean.recommend.RecommendDataBean;
import jcp.com.exiyou.ui.community.bean.recommend.RecommendIndex;
import jcp.com.exiyou.ui.community.contract.RecommendContract;
import jcp.com.exiyou.ui.community.model.RecommendModel;
import jcp.com.exiyou.ui.community.presenter.RecommendPresenter;


/**
 * Created by SweetDream on 2017/3/25.
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter, RecommendModel> implements RecommendContract.View, SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener {

    private static final String TAG = RecommendFragment.class.getSimpleName();
    @BindView(R2.id.recommend_list_view)
    ListView mListView;
    @BindView(R2.id.recommend_refresh)
    SwipeRefreshLayout mRefresh;

    private int page = 1;
    private ImageView askImg, visaImg, togetherImg, photographerImg, qyerstoreImg;
    private TextView askText, visaText, togetherText, photographerText, qyerstoreText;
    private ImageView qyereliteImg, monthlysuggestImg, activityImg;
    private TextView qyereliteText, monthlysuggestText, activityText;
    private RecommendListAdapter mAdapter;
    private View footer;
    private boolean isBottom;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);

    }

    @Override
    public void initView() {
        // 导入头布局
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.recommend_header, null);

        footer = LayoutInflater.from(getActivity()).inflate(R.layout.recommend_footer, null);
        findViewByIdWithHeader(header);
        mListView.addHeaderView(header);
        if (mListView.getFooterViewsCount() == 0) {
            mListView.addFooterView(footer);
        }

        mAdapter = new RecommendListAdapter(getActivity(), null, null, R.layout.recommend_list_item);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);
        mRefresh.setColorSchemeResources(R.color.color_green_tab);
        mRefresh.setOnRefreshListener(this);

        getNetworkRes(page);

    }

    private void findViewByIdWithHeader(View header) {
        askImg = ((ImageView) header.findViewById(R.id.recommend_icon_ask_img));
        visaImg = (ImageView) header.findViewById(R.id.recommend_icon_visa_img);
        togetherImg = (ImageView) header.findViewById(R.id.recommend_icon_together_img);
        photographerImg = (ImageView) header.findViewById(R.id.recommend_icon_photographer_img);
        qyerstoreImg = (ImageView) header.findViewById(R.id.recommend_icon_qyerstore_img);
        activityImg = (ImageView) header.findViewById(R.id.recommend_tag_activity_img);
        monthlysuggestImg = (ImageView) header.findViewById(R.id.recommend_tag_monthlysuggest_img);
        qyereliteImg = (ImageView) header.findViewById(R.id.recommend_tag_qyerelite_img);
        askText = (TextView) header.findViewById(R.id.recommend_icon_ask_text);
        visaText = (TextView) header.findViewById(R.id.recommend_icon_visa_text);
        photographerText = (TextView) header.findViewById(R.id.recommend_icon_photographer_text);
        togetherText = (TextView) header.findViewById(R.id.recommend_icon_together_text);
        qyerstoreText = (TextView) header.findViewById(R.id.recommend_icon_qyerstore_text);
        activityText = (TextView) header.findViewById(R.id.recommend_tag_activity_text);
        qyereliteText = (TextView) header.findViewById(R.id.recommend_tag_qyerelite_text);
        monthlysuggestText = (TextView) header.findViewById(R.id.recommend_tag_monthlysuggest_text);
    }

    private void getNetworkRes(int page) {
        // 发送网络请求,获取得到的数据
        LoadAnimation.LoadingAnimation(footer, true);
        if (NetUtil.getNetState(getActivity())) {
            mPresenter.requestRecommendRes(page);
        } else {
            LoadAnimation.LoadingAnimation(footer, false);
            mRefresh.setRefreshing(false);
        }
    }

    @Override
    public void returnRecommendRes(RecommendDataBean recommendDataBean) {
        initHeader(recommendDataBean);
        if (page == 1) {
            updateData(State.START, recommendDataBean.getIndex_list());
        } else {
            updateData(State.END, recommendDataBean.getIndex_list());
        }
        LoadAnimation.LoadingAnimation(footer, false);
        mRefresh.setRefreshing(false);
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

    private void initHeader(RecommendDataBean recommendDataBean) {
        if (recommendDataBean != null) {
            Log.e(TAG, "initHeader: ");
            Picasso.with(getActivity()).load(recommendDataBean.getIcon_list().get(0).getIcon_pic()).into(visaImg);
            Picasso.with(getActivity()).load(recommendDataBean.getIcon_list().get(1).getIcon_pic()).into(askImg);
            Picasso.with(getActivity()).load(recommendDataBean.getIcon_list().get(2).getIcon_pic()).into(togetherImg);
            Picasso.with(getActivity()).load(recommendDataBean.getIcon_list().get(3).getIcon_pic()).into(photographerImg);
            Picasso.with(getActivity()).load(recommendDataBean.getIcon_list().get(4).getIcon_pic()).into(qyerstoreImg);

            visaText.setText(recommendDataBean.getIcon_list().get(0).getIcon());
            askText.setText(recommendDataBean.getIcon_list().get(1).getIcon());
            togetherText.setText(recommendDataBean.getIcon_list().get(2).getIcon());
            photographerText.setText(recommendDataBean.getIcon_list().get(3).getIcon());
            qyerstoreText.setText(recommendDataBean.getIcon_list().get(4).getIcon());

            Picasso.with(getActivity()).load(recommendDataBean.getTag_list().get(0).getTag_cover()).into(qyereliteImg);
            Picasso.with(getActivity()).load(recommendDataBean.getTag_list().get(1).getTag_cover()).into(monthlysuggestImg);
            Picasso.with(getActivity()).load(recommendDataBean.getTag_list().get(2).getTag_cover()).into(activityImg);

            qyereliteText.setText(recommendDataBean.getTag_list().get(0).getTag_name());
            monthlysuggestText.setText(recommendDataBean.getTag_list().get(1).getTag_name());
            activityText.setText(recommendDataBean.getTag_list().get(2).getTag_name());

        }
    }

    @Override
    public void onRefresh() {
        page = 1;
        getNetworkRes(page);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                if (isBottom) {
                    footer.setVisibility(View.VISIBLE);
                    LoadAnimation.LoadingAnimation(footer, true);
                    getNetworkRes(++page);
                } else {
                    footer.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        isBottom = firstVisibleItem + visibleItemCount == totalItemCount;
    }

    enum State {
        START, END
    }

    private void updateData(State state, List<RecommendIndex> mData) {
        switch (state) {
            case START:
                mAdapter.updateRes(mData);
                break;
            case END:
                mAdapter.addRes(mData);
                break;
        }
    }

}

