package jcp.com.exiyou.ui.community.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.L;

import java.util.List;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseRecyclerAdapter;
import jcp.com.exiyou.ui.community.activitys.EnterIntoJumpActivity;
import jcp.com.exiyou.ui.community.bean.enterinto.GroupBean;


/**
 * Created by SweetDream on 2017/3/29.
 */

public class RightRecyclerAdapter extends BaseRecyclerAdapter<GroupBean> {

    private DisplayImageOptions mOptions;
    private int index;
    private Context context;

    private int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public RightRecyclerAdapter(Context context, String mType, List<GroupBean> data, int... layoutId) {
        super(context, mType, data, layoutId);
        this.context = context;
        mOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.mipmap.ic_qyer_gray_60)
                .showImageOnFail(R.mipmap.ic_qyer_gray_60)
                .displayer(new RoundedBitmapDisplayer(15))
                .build();
    }

    @Override
    protected void loadData(ViewHolder holder, GroupBean item, final int position) {

        holder.setText(R.id.enter_into_right_name, item.getName());
        holder.setText(R.id.enter_into_right_description, item.getDescription());
        holder.setText(R.id.enter_into_right_total_threads, item.getTotal_threads());
        ImageView imageView = (ImageView) holder.findView(R.id.enter_into_right_image);
        if (position == 0 && getIndex() == 0) {
            ImageLoader.getInstance().displayImage(item.getPhoto() + R.drawable.ic_group_ask, imageView, mOptions);
        } else {
            ImageLoader.getInstance().displayImage(item.getPhoto(), imageView, mOptions);
        }

        final  GroupBean finalItem = item;
        holder.findView(R.id.enter_into_right_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0 && getIndex() == 0) {

                } else {
                    Intent intent = new Intent(context, EnterIntoJumpActivity.class);
                    intent.putExtra("fid", finalItem.getId());
                    context.startActivity(intent);
                }
            }
        });


    }
}
