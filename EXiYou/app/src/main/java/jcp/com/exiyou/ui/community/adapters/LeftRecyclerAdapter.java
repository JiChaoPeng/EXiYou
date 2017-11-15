package jcp.com.exiyou.ui.community.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseRecyclerAdapter;
import jcp.com.exiyou.base.event.OnItemClickListener;
import jcp.com.exiyou.ui.community.bean.enterinto.ForumListBean;

import static android.R.attr.name;

/**
 * Created by SweetDream on 2017/3/29.
 */

public class LeftRecyclerAdapter extends BaseRecyclerAdapter<ForumListBean> implements View.OnClickListener {

    private static final String TAG = LeftRecyclerAdapter.class.getSimpleName();
    private int index;
    private RecyclerView recyclerView;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public LeftRecyclerAdapter(Context context, String mType, List<ForumListBean> data, int... layoutId) {
        super(context, mType, data, layoutId);
    }

    @Override
    protected void loadData(ViewHolder holder, ForumListBean item, int position) {
        Log.e(TAG, "loadData: " + item.getName());
        holder.setText(R.id.enter_into_left_name, item.getName());
        LinearLayout layout = (LinearLayout) holder.findView(R.id.enter_into_left_layout);

        if (index == position) {
            layout.setSelected(true);
        } else {
            layout.setSelected(false);
        }
        if (index == 0) {
            onItemClickListener.onItemClick(recyclerView, index);
        }
        layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildAdapterPosition(v);
        switch (v.getId()) {
            case R.id.enter_into_left_layout:
                index = position;
                onItemClickListener.onItemClick(recyclerView, position);
                break;
        }
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }
}
