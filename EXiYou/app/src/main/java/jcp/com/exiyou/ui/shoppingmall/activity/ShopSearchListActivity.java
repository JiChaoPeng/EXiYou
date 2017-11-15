package jcp.com.exiyou.ui.shoppingmall.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseActivity;
import jcp.com.exiyou.base.util.LoadAnimation;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchListAdapter;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchOrderAdapter;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchPWListAdapter1;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchPWListAdapter2;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSearchPWListAdapter3;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import jcp.com.exiyou.ui.shoppingmall.model.ShopSearchModel;
import jcp.com.exiyou.ui.shoppingmall.presenter.ShopSearchPresenter;

public class ShopSearchListActivity extends BaseActivity<ShopSearchPresenter, ShopSearchModel> implements ShopContract.ShopSearchView, SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener {

    private static final String TAG = ShopSearchListActivity.class.getSimpleName();
    private ShopSearchListAdapter adapter;
    private int windowWidth;
    private int windowHeight;
    private View popupLayout, popupLayout2, popupLayout3;
    private ListView list1;
    private ListView list2;
    private ListView list3;
    private ListView list4;
    private PopupWindow popupWindow;
    private List<ShopSearchListBean.DataBean.FiltersBean.PoiBean> poi;
    private ShopSearchPWListAdapter1 adapter1;
    private ShopSearchPWListAdapter2 adapter2;
    private ShopSearchPWListAdapter3 adapter3;

    private List<ShopSearchListBean.DataBean.FiltersBean.PoiBean.CountryBean> country;
    private List<ShopSearchListBean.DataBean.FiltersBean.PoiBean.CountryBean.CityListBean> city_list;
    private int flag = 0;
    private int order;


    @BindView(R2.id.shoppage_select_title1)
    TextView title1;
    private ShopSearchOrderAdapter adapter4;
    private List<ShopSearchListBean.DataBean.FiltersBean.OrderBean> orderData = new ArrayList<>();

    @OnClick(R2.id.shoppage_select_title1)
    public void selectTitle1(View v) {
        showPopBtn();
        popupWindow = new PopupWindow(popupLayout, windowWidth, windowHeight);
        popupWindow.showAsDropDown(v);

    }

    @BindView(R2.id.shoppage_select_title2)
    TextView title2;

    @OnClick(R2.id.shoppage_select_title2)
    public void selectTitle2(View v) {
        showOrder();
        popupWindow = new PopupWindow(popupLayout2, windowWidth, windowHeight);
        popupWindow.showAsDropDown(v);

    }

    private int page3 = 1;
    private int page4 = 1;
    private boolean hasCity = false;

    private void showOrder() {
        popupLayout2 = LayoutInflater.from(this).inflate(R.layout.shoppage_search_popupwindow2, null);
        list4 = (ListView) popupLayout2.findViewById(R.id.shoppage_search_popupwindow2_listview1);
        adapter4 = new ShopSearchOrderAdapter(this, null, orderData, R.layout.shoppage_search_popup_list_item);
        list4.setAdapter(adapter4);

        list4.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isUpdate = true;
                page3 = 1;
                page4 = 1;
                order = orderData.get(position).getId();
                if (hasCity) {
                    mPresenter.getShopSearchRes3(stg_id, String.valueOf(page3), city_id, order);
                    title2.setText(orderData.get(position).getOrder_name());
                    flag = 2;
                } else {
                    mPresenter.getShopSearchRes4(stg_id, String.valueOf(page4), order);
                    title2.setText(orderData.get(position).getOrder_name());
                    flag = 3;
                }
                popupWindow.dismiss();
            }
        });

        popupLayout2.findViewById(R.id.shoppage_search_popupwindow2_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }


    @OnClick(R2.id.shoppage_select_title3)
    public void selectTitle3(View v) {
        showMoreSearch();
        popupWindow = new PopupWindow(popupLayout3, windowWidth, windowHeight);
        popupWindow.showAsDropDown(v);
    }

    private void showMoreSearch() {
        popupLayout3 = LayoutInflater.from(this).inflate(R.layout.shoppage_search_popupwindow3, null);
        popupLayout3.findViewById(R.id.shoppage_search_popupwindow3_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    @BindView(R2.id.shoppage_style_listview)
    ListView mListView;

    @OnClick(R2.id.shoppage_style_back)
    public void styleBack() {
        this.finish();
    }

    @BindView(R2.id.shoppage_style_title)
    TextView mBarTitle;
    @BindView(R2.id.shoppage_style_swiperefreshlayout)
    SwipeRefreshLayout mRefresh;


    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_style_one;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);
    }

    private int page = 1;
    private boolean isUpdate = true;
    private String stg_id;
    private View footer;

    @Override
    public void initView() {
        //请求数据,获取返回的listview中的数据,加载数据
        //下拉加载与上拉刷新的添加
        //条件筛选的级联列表的添加

        final Intent intent = getIntent();
        stg_id = intent.getStringExtra("stg_id");
        Log.e(TAG, "initView: " + stg_id);
        String title = intent.getStringExtra("title");
        mBarTitle.setText(title);

        //初始化swipeRefreshLayout
        mRefresh.setColorSchemeResources(R.color.color_green_tab);
        mRefresh.setOnRefreshListener(this);
        //请求数据
        mPresenter.getShopSearchRes(stg_id, String.valueOf(page));
        //添加尾布局
        footer = LayoutInflater.from(this).inflate(R.layout.recommend_footer, null);
        mListView.addFooterView(footer);
        footer.setVisibility(View.GONE);

        adapter = new ShopSearchListAdapter(this, null, listData, R.layout.shoppage_search_list_item);
        mListView.setAdapter(adapter);
        mListView.setOnScrollListener(this);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent5 = new Intent(ShopSearchListActivity.this, ShopWebViewIdDetails.class);
                intent5.putExtra("url", listData.get(position).getUrl());
                intent5.putExtra("type", "2");
                startActivity(intent5);
            }
        });

        windowWidth = getWindowManager().getDefaultDisplay().getWidth();
        windowHeight = getWindowManager().getDefaultDisplay().getHeight();

    }

    ShopSearchListBean shopData = new ShopSearchListBean();
    List<ShopSearchListBean.DataBean.ListBeanX> listData = new ArrayList<>();

    private boolean isFirst = true;

    @Override
    public void returnShopSearchListData(ShopSearchListBean data) {
        shopData = data;

        listData = data.getData().getList();

        Log.e(TAG, "returnShopSearchListData: " + listData.toString());
        orderData = data.getData().getFilters().getOrder();

        mRefresh.setRefreshing(false);
//        if(listData.size() == 0){
//            Toast.makeText(this, "已经到达底部啦", Toast.LENGTH_SHORT).show();
//            footer.setVisibility(View.GONE);
//            return;
//        }
        
        if (isUpdate) {
            Toast.makeText(this, "刷新完成", Toast.LENGTH_SHORT).show();
            adapter.updateRes(listData);
        } else {
            Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
            adapter.addRes(listData);
            footer.setVisibility(View.GONE);
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
    public void onRefresh() {
//        page = 1;
        isUpdate = true;
//        mPresenter.getShopSearchRes(stg_id, String.valueOf(page));

        Toast.makeText(this, "已经是最新了呦", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                if (isBottom) {
                    footer.setVisibility(View.VISIBLE);
                    LoadAnimation.LoadingAnimation(footer, true);
                    isUpdate = false;
                    if (flag == 0) {
                        mPresenter.getShopSearchRes(stg_id, String.valueOf(++page));
                    } else if (flag == 1) {
                        mPresenter.getShopSearchRes2(stg_id, String.valueOf(++page2), city_id);
                    } else if (flag == 2) {
                        mPresenter.getShopSearchRes3(stg_id, String.valueOf(++page3), city_id, order);
                    } else if (flag == 3) {
                        mPresenter.getShopSearchRes4(stg_id, String.valueOf(++page4), order);
                    }
                }
                break;
        }
    }

    private boolean isBottom;
    private int page2 = 1;
    private String city_id;

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        isBottom = firstVisibleItem + visibleItemCount == totalItemCount;
    }

    private void showPopBtn() {

        popupLayout = LayoutInflater.from(this).inflate(R.layout.shoppage_search_popupwindow, null);
        list1 = (ListView) popupLayout.findViewById(R.id.shoppage_search_popupwindow_listview1);
        list2 = ((ListView) popupLayout.findViewById(R.id.shoppage_search_popupwindow_listview2));
        list3 = ((ListView) popupLayout.findViewById(R.id.shoppage_search_popupwindow_listview3));
        popupLayout.findViewById(R.id.shoppage_search_popupwindow_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                list3.setVisibility(View.GONE);
            }
        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    return;
                country = poi.get(position).getCountry();
                adapter2.updateRes(country);
                list3.setVisibility(View.GONE);
            }
        });

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    return;
                city_list = country.get(position).getCity_list();
                adapter3.updateRes(city_list);
                list3.setVisibility(View.VISIBLE);
            }
        });

        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //刷新页面,将点击项的text作为拼接值,刷新数据源
//                Log.e(TAG, "onItemClick: 333");
                if (position == 0)
                    return;
                city_id = String.valueOf(city_list.get(position).getValue());
                Log.e(TAG, "onItemClick: 此时的city_id为" +city_id);
                title1.setText(city_list.get(position).getName());
                hasCity = true;
                isUpdate = true;
                mPresenter.getShopSearchRes2(stg_id, String.valueOf(page2), city_id);
                popupWindow.dismiss();
                flag = 1;
                list3.setVisibility(View.GONE);
                title2.setText("智能排序");
            }
        });

//        Log.e(TAG, "showPopBtn: "+ shopData.getData().getFilters().getPoi());
        if (isFirst) {
            poi = shopData.getData().getFilters().getPoi();
            isFirst = false;
        }

        adapter1 = new ShopSearchPWListAdapter1(this, null, poi, R.layout.shoppage_search_popup_list_item);
        list1.setAdapter(adapter1);
        adapter2 = new ShopSearchPWListAdapter2(this, null, null, R.layout.shoppage_search_popup_list_item);
        list2.setAdapter(adapter2);
        adapter3 = new ShopSearchPWListAdapter3(this, null, null, R.layout.shoppage_search_popup_list_item);
        list3.setAdapter(adapter3);
    }

}
