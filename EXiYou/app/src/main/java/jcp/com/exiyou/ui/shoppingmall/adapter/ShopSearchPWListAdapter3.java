package jcp.com.exiyou.ui.shoppingmall.adapter;

import android.content.Context;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchListBean;


public class ShopSearchPWListAdapter3 extends BaseListViewAdapter<ShopSearchListBean.DataBean.FiltersBean.PoiBean.CountryBean.CityListBean>{

    public ShopSearchPWListAdapter3(Context context, String mType, List mData, int... layoutIds) {
        super(context, mType, mData, layoutIds);
    }

    @Override
    protected void loadData(ViewHolder holder, ShopSearchListBean.DataBean.FiltersBean.PoiBean.CountryBean.CityListBean item, int position) {
        holder.setText(R.id.shoppage_search_popupwindow_list_item,item.getName());
    }
}
