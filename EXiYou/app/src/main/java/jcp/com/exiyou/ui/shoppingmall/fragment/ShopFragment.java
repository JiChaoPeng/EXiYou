package jcp.com.exiyou.ui.shoppingmall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseFragment;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopRecycleAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopBean;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopHotGoods;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopListBean;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopListHotGoods;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import jcp.com.exiyou.ui.shoppingmall.model.ShopModel;
import jcp.com.exiyou.ui.shoppingmall.presenter.ShopPresenter;


public class ShopFragment extends BaseFragment<ShopPresenter, ShopModel> implements ShopContract.ShopView {

    private static final String TAG = ShopFragment.class.getSimpleName();
    public int page = 1;
    private ShopRecycleAdapter adapter;

    @BindView(R2.id.fragment_shopage_recycleview)
    RecyclerView mRecyclerView;

    @BindView(R2.id.fragment_shoppage_more)
    LinearLayout mMore;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_shoppage;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);

    }

    List<ShopHotGoods> data = new ArrayList<>();
    ShopBean data1 = new ShopBean();

    @Override
    public void initView() {
        mPresenter.getShopHeaderRes();
        mPresenter.getShopRes(page);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        if (layoutManager instanceof GridLayoutManager) {
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int size = 1;
                    switch (position) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            size = 2;
                            break;
                    }
                    return size;
                }
            });
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

    }

    @Override
    public void returnShopData(ShopListHotGoods data) {
        this.data = data.getHot_goods();
        adapter.addRes(this.data, data1);
        mMore.setVisibility(View.GONE);
    }

    @Override
    public void retrunShopHeaderRes(ShopListBean data) {
        this.data1 = data.getData();

//        Log.e(TAG, "initView: adapter初始化");
        adapter = new ShopRecycleAdapter(getActivity(), this.data, data1);

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (isBottom(recyclerView)) {
                    //滑动到底部

                    mMore.setVisibility(View.VISIBLE);
                    mPresenter.getShopRes(++page);
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }
        });

        mRecyclerView.setAdapter(adapter);
        adapter.addRes(this.data, data1);
    }

    protected boolean isBottom(RecyclerView recyclerView) {
        if (recyclerView == null)
            return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

}
