package jcp.com.exiyou.ui.shoppingmall.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseRecyclerAdapter;
import jcp.com.exiyou.ui.shoppingmall.activity.ShopSearchSecondActicity;
import jcp.com.exiyou.ui.shoppingmall.activity.ShopWebViewIdDetails;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondBean;


public class ShopSearchSecondAdapter extends BaseRecyclerAdapter<ShopSearchSecondBean.ShopSearchSecondList> implements View.OnClickListener{

    private Context context;
    private List<ShopSearchSecondBean.ShopSearchSecondList> data;
    private RecyclerView mRecyclerView;

    public static final String TAG = ShopSearchSecondActicity.class.getSimpleName();

    public ShopSearchSecondAdapter(Context context, String mType, List<ShopSearchSecondBean.ShopSearchSecondList> data, int... layoutId) {
        super(context, mType, data, layoutId);
        this.context = context;
        this.data = data;
    }

    @Override
    protected void loadData(ViewHolder holder, ShopSearchSecondBean.ShopSearchSecondList item, int position) {
        ImageView imageView = (ImageView) holder.findView(R.id.shoppage_search_listitem_image);
        Picasso.with(context).load(item.getPhoto()).into(imageView);
        holder.setText(R.id.shoppage_search_listitem_title,item.getTitle());
        holder.setText(R.id.shoppage_search_listitem_sold,item.getSold());
        holder.setText(R.id.shoppage_search_listitem_price,item.getPrice());
        holder.setText(R.id.shoppage_search_listitem_mark,item.getMark());

        holder.itemView.setOnClickListener(this);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }


    @Override
    public void onClick(View v) {
        Log.e(TAG, "onClick: ");

        int position = mRecyclerView.getChildAdapterPosition(v);
        Intent intent = new Intent(context, ShopWebViewIdDetails.class);
        intent.putExtra("url", data.get(position).getUrl());
        intent.putExtra("type", "2");
        context.startActivity(intent);
    }
}
