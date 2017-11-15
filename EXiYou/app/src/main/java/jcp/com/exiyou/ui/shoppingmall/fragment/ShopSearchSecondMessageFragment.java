package jcp.com.exiyou.ui.shoppingmall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseFragment;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchSecondAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondListBean;


public class ShopSearchSecondMessageFragment extends BaseFragment {

    @BindView(R2.id.shoppage_search_second_listview)
    RecyclerView mListView;

    private ShopSearchSecondListBean data;

    public void setData(ShopSearchSecondListBean data) {
        this.data = data;
    }

    @Override
    public int getLayoutId() {
        return R.layout.shoppage_search_second_messagerecycler;
    }

    @Override
    public void initPresenter() {

    }

    private ShopSearchSecondAdapter adapter;

    @Override
    public void initView() {

        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new ShopSearchSecondAdapter(getActivity(), null, data.getData().getList(), R.layout.shoppage_search_list_item);
        mListView.setAdapter(adapter);


//        adapter = new ShopSearchSecondAdapter(getActivity(),null,data.getData().getList(),R.layout.shoppage_search_list_item);
//        mListView.setAdapter(adapter);
//        mListView.setOnItemClickListener(this);
    }

}
