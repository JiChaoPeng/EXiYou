package jcp.com.exiyou.ui.community.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.squareup.picasso.Picasso;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.community.activitys.RecommendJumpActivity;
import jcp.com.exiyou.ui.community.bean.recommend.RecommendIndex;


/**
 * Created by SweetDream on 2017/3/27.
 */

public class RecommendListAdapter extends BaseListViewAdapter<RecommendIndex> {

    private Context context;
    private DisplayImageOptions mOptions;

    public RecommendListAdapter(Context context, String mType, List<RecommendIndex> mData, int... layoutIds) {
        super(context, mType, mData, layoutIds);
        this.context = context;
        mOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.mipmap.ic_qyer_gray_120)
                .showImageOnFail(R.mipmap.ic_qyer_gray_120)
                .displayer(new CircleBitmapDisplayer())
                .build();
    }

    @Override
    protected void loadData(ViewHolder holder, final RecommendIndex item, int position) {
        holder.setText(R.id.recommend_item_forum, item.getForum());
        holder.setText(R.id.recommend_item_author, item.getAuthor());
        holder.setText(R.id.recommend_item_title, item.getTitle());
        holder.setText(R.id.recommend_item_reply_num, String.valueOf(item.getReply_num()));
        holder.setText(R.id.recommend_item_reply_time, item.getReply_time());
        ImageView imageView = (ImageView) holder.findView(R.id.recommend_item_avatar);
        ImageLoader.getInstance().displayImage(item.getAvatar(), imageView, mOptions);

        ImageView one = (ImageView) holder.findView(R.id.recommend_item_big_pic_one);
        ImageView two = (ImageView) holder.findView(R.id.recommend_item_big_pic_two);
        ImageView three = (ImageView) holder.findView(R.id.recommend_item_big_pic_three);
        int size = item.getBigpic_arr().size();
        if (size == 0) {
            one.setVisibility(View.GONE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.GONE);
        } else if (size == 1) {
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            Picasso.with(context).load(item.getBigpic_arr().get(0)).centerCrop().fit().into(one);
        } else if (size == 2) {
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.INVISIBLE);
            Picasso.with(context).load(item.getBigpic_arr().get(0)).centerCrop().fit().into(one);
            Picasso.with(context).load(item.getBigpic_arr().get(1)).centerCrop().fit().into(two);
        } else if (size == 3) {
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.VISIBLE);
            Picasso.with(context).load(item.getBigpic_arr().get(0)).centerCrop().fit().into(one);
            Picasso.with(context).load(item.getBigpic_arr().get(1)).centerCrop().fit().into(two);
            Picasso.with(context).load(item.getBigpic_arr().get(2)).centerCrop().fit().into(three);
        }

        // 跳转网页
        holder.findView(R.id.recommend_item_card_view).
                setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, RecommendJumpActivity.class);
                                intent.putExtra("url_path", item.getAppview_url());
                                context.startActivity(intent);
                            }
                        });
    }
}
