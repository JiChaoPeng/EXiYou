package jcp.com.exiyou.ui.shoppingmall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSpecialBean;


public class ShopSpecialListAdapter extends BaseListViewAdapter<ShopSpecialBean.ShopSpecialList>{

    private Context context;
    public ShopSpecialListAdapter(Context context, String mType, List<ShopSpecialBean.ShopSpecialList> mData, int... layoutIds) {
        super(context, mType, mData, layoutIds);
        this.context = context;
    }

    @Override
    protected void loadData(ViewHolder holder, ShopSpecialBean.ShopSpecialList item, int position) {
        ImageView imageView = (ImageView) holder.findView(R.id.shoppage_special_listitem_image);
        Picasso.with(context).load(item.getPhoto()).into(imageView);
        holder.setText(R.id.shoppage_special_listitem_title,item.getTitle());
        holder.setText(R.id.shoppage_special_listitem_sold,item.getSold());
        holder.setText(R.id.shoppage_special_listitem_price,item.getPrice());
    }
}
