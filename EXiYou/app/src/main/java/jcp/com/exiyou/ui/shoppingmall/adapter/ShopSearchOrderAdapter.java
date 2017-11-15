package jcp.com.exiyou.ui.shoppingmall.adapter;

import android.content.Context;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchListBean;


public class ShopSearchOrderAdapter extends BaseListViewAdapter<ShopSearchListBean.DataBean.FiltersBean.OrderBean>{

    public ShopSearchOrderAdapter(Context context, String mType, List<ShopSearchListBean.DataBean.FiltersBean.OrderBean> mData, int... layoutIds) {
        super(context, mType, mData, layoutIds);
    }

    @Override
    protected void loadData(ViewHolder holder, ShopSearchListBean.DataBean.FiltersBean.OrderBean item, int position) {
        holder.setText(R.id.shoppage_search_popupwindow_list_item,item.getOrder_name());
    }
}
