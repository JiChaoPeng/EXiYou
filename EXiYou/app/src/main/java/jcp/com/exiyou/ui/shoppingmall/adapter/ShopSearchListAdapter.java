package jcp.com.exiyou.ui.shoppingmall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchListBean;



public class ShopSearchListAdapter extends BaseListViewAdapter<ShopSearchListBean.DataBean.ListBeanX>{

    private Context context;
    public ShopSearchListAdapter(Context context, String mType, List<ShopSearchListBean.DataBean.ListBeanX> mData, int... layoutIds) {
        super(context, mType, mData, layoutIds);
        this.context = context;
    }

    @Override
    protected void loadData(ViewHolder holder, ShopSearchListBean.DataBean.ListBeanX item, int position) {
        ImageView imageView = (ImageView) holder.findView(R.id.shoppage_search_listitem_image);
        Picasso.with(context).load(item.getPhoto()).into(imageView);
        holder.setText(R.id.shoppage_search_listitem_title,item.getTitle());
        holder.setText(R.id.shoppage_search_listitem_sold,item.getSold());
        holder.setText(R.id.shoppage_search_listitem_price,item.getPrice());
        holder.setText(R.id.shoppage_search_listitem_mark,item.getMark());
    }
}
