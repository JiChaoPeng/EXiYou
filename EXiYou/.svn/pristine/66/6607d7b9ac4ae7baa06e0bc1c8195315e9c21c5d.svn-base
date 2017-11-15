package jcp.com.exiyou.ui.community.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.community.activitys.RecommendJumpActivity;
import jcp.com.exiyou.ui.community.bean.enterintodetails.EntryBean;


/**
 * Created by SweetDream on 2017/3/31.
 */

public class EnterIntoDetailsAdapter extends BaseListViewAdapter<EntryBean> {

    private static final String TAG = EnterIntoDetailsAdapter.class.getSimpleName();
    private Context context;
    private DisplayImageOptions mOptions;
    private String start;
    private String end;

    public EnterIntoDetailsAdapter(Context context, String mType, List<EntryBean> mData, int... layoutIds) {
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
    public int getItemViewType(int position) {
        int type = 0;
        EntryBean entryBean = getItem(position);
        Class<?> cls = entryBean.getClass();
        if (mType != null) {
            try {
                Field field = cls.getDeclaredField(mType);
                // 添加访问权限
                field.setAccessible(true);
                type = field.getInt(entryBean);
                if (type == 3) {
                    return 1;
                } else {
                    return 0;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return type;
    }

    @Override
    protected void loadData(ViewHolder holder, final EntryBean item, int position) {

        Log.e(TAG, "loadData: " + getItemViewType(position));
        switch (getItemViewType(position)) {
            case 0:
                holder.setText(R.id.enter_into_item_author, item.getUsername());
                holder.setText(R.id.enter_into_item_title, item.getTitle());
                holder.setText(R.id.enter_into_item_views, item.getViews() + "人浏览");
                holder.setText(R.id.enter_into_item_reply_num, item.getReplys());
                String replay_time = (String) DateFormat.format("yyyy-MM-dd", Long.parseLong(item.getPublish_time()) * 1000);
                holder.setText(R.id.enter_into_item_reply_time, replay_time);
                ImageView imageView = (ImageView) holder.findView(R.id.enter_into_item_avatar);
                ImageLoader.getInstance().displayImage(item.getAvatar(), imageView, mOptions);

                ImageView one = (ImageView) holder.findView(R.id.enter_into_item_big_pic_one);
                ImageView two = (ImageView) holder.findView(R.id.enter_into_item_big_pic_two);
                ImageView three = (ImageView) holder.findView(R.id.enter_into_item_big_pic_three);
                int size = item.getPhotoarr().size();
                if (size == 0) {
                    one.setVisibility(View.GONE);
                    two.setVisibility(View.GONE);
                    three.setVisibility(View.GONE);
                } else if (size == 1) {
                    one.setVisibility(View.VISIBLE);
                    two.setVisibility(View.INVISIBLE);
                    three.setVisibility(View.INVISIBLE);
                    Picasso.with(context).load(item.getPhotoarr().get(0)).centerCrop().fit().into(one);
                } else if (size == 2) {
                    one.setVisibility(View.VISIBLE);
                    two.setVisibility(View.VISIBLE);
                    three.setVisibility(View.INVISIBLE);
                    Picasso.with(context).load(item.getPhotoarr().get(0)).centerCrop().fit().into(one);
                    Picasso.with(context).load(item.getPhotoarr().get(1)).centerCrop().fit().into(two);
                } else if (size == 3) {
                    one.setVisibility(View.VISIBLE);
                    two.setVisibility(View.VISIBLE);
                    three.setVisibility(View.VISIBLE);
                    Picasso.with(context).load(item.getPhotoarr().get(0)).centerCrop().fit().into(one);
                    Picasso.with(context).load(item.getPhotoarr().get(1)).centerCrop().fit().into(two);
                    Picasso.with(context).load(item.getPhotoarr().get(2)).centerCrop().fit().into(three);
                }

                holder.findView(R.id.enter_into_item_card_view)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, RecommendJumpActivity.class);
                                intent.putExtra("url_path", item.getView_url());
                                context.startActivity(intent);
                            }
                        });
                break;
            case 1:
                holder.setText(R.id.enter_into_item_author, item.getUsername());
                holder.setText(R.id.enter_into_item_title, item.getTitle());
                holder.setText(R.id.enter_into_item_views, item.getViews() + "人浏览");
                holder.setText(R.id.enter_into_item_reply_num, item.getReplys());
                String replay_time1 = (String) DateFormat.format("yyyy-MM-dd", Long.parseLong(item.getPublish_time()) * 1000);
                holder.setText(R.id.enter_into_item_reply_time, replay_time1);
                holder.setText(R.id.enter_into_item_city_str, item.getCity_str());
                if (item.getStart_time() != null) {
                    start = (String) DateFormat.format("yyyy.MM.dd", Long.parseLong(item.getStart_time()) * 1000);
                } else {
                    start = "1970.1.1";
                }
                if (item.getEnd_time() != null) {
                    end = (String) DateFormat.format("yyyy.MM.dd", Long.parseLong(item.getEnd_time()) * 1000);
                } else {
                    end = "1970.1.1";
                }
                holder.setText(R.id.enter_into_item_start_end_time, start + "-" + end);
                ImageView imageView1 = (ImageView) holder.findView(R.id.enter_into_item_avatar);
                ImageLoader.getInstance().displayImage(item.getAvatar(), imageView1, mOptions);

                holder.findView(R.id.enter_into_item_card_view)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, RecommendJumpActivity.class);
                                intent.putExtra("url_path", item.getView_url());
                                context.startActivity(intent);
                            }
                        });
                break;
        }
    }
}
