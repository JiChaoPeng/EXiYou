package jcp.com.exiyou.ui.destination.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcp.com.exiyou.R;
import jcp.com.exiyou.base.adapters.BaseListViewAdapter;
import jcp.com.exiyou.ui.destination.bean.DestinationCityBean;
import jcp.com.exiyou.ui.destination.bean.DestinationCityListBean;
import jcp.com.exiyou.ui.destination.bean.DestinationModelBean;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by 超鹏 on 2017/3/27.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //         .............................................
 * //
 * //            佛祖镇楼                  BUG辟易
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；程序人员写程序，又拿程序换酒钱。酒醒只在网上坐，酒醉还来网下眠；酒醉酒醒日复日，网上网下年复年。
 * 宁愿老死程序间，只要老板多发钱；小车大房不去想，撰个二千好过年。若要见识新世面，公务员比程序员；一个在天一在地，而且还比我们闲。
 * 别人看我穿白领，我看别人穿名牌；天生我才写程序，臀大近视肩周炎。年复一年春光度，度得他人做老板；老板扣我薄酒钱，没有酒钱怎过年。
 * 春光逝去皱纹起，作起程序也委靡；来到水源把水灌，打死不做程序员。别人笑我忒疯癫，我笑他人命太贱；状元三百六十行，偏偏来做程序员。
 * 但愿老死电脑间，不愿鞠躬老板前；奔驰宝马贵者趣，公交自行程序员。别人笑我忒疯癫，我笑自己命太贱；不见满街漂亮妹，哪个归得程序员。
 * 不想只挣打工钱，那个老板愿发钱；小车大房咱要想，任我享用多悠闲。比尔能搞个微软，我咋不能捞点钱；一个在天一在地，定有一日乾坤翻。
 * 我在天来他在地，纵横天下山水间；傲视武林豪杰墓，一樽还垒风月山。电脑面前眼发直，眼镜下面泪茫茫；做梦发财好几亿，从此不用手指忙。
 * 哪知梦醒手空空，老板看到把我训；待到老时眼发花，走路不知哪是家。小农村里小民房，小民房里小民工；小民工人写程序，又拿代码讨赏钱。
 * 钱空只在代码中，钱醉仍在代码间；有钱无钱日复日，码上码下年复年。但愿老死代码间，不愿鞠躬奥迪前，奥迪奔驰贵者趣，程序代码贫者缘。
 * 若将贫贱比贫者，一在平地一在天；若将贫贱比车马，他得驱驰我得闲。别人笑我忒疯癫，我笑他人看不穿；不见盖茨两手间，财权富贵世人鉴。
 */

public class DestinationCityListAdapter extends BaseAdapter {
    private static final String TAG = DestinationCityListAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    private int[] layoutIds;
    private DestinationCityListBean mData;
    private Context context;
    private DisplayImageOptions mOptions;

    public DestinationCityListAdapter(Context context, String mType, int... layoutIds) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.layoutIds = layoutIds;
        mOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.mipmap.ic_qyer_gray_120)
                .showImageOnFail(R.mipmap.ic_qyer_gray_120)
                .showImageForEmptyUri(R.mipmap.ic_qyer_gray_120)
                .displayer(new RoundedBitmapDisplayer(10))
                .build();


    }

    public void updateRes(DestinationCityListBean data) {
        if (data != null) {
            if (data.getCitycount()%2!=0){
                data.getCitylist().add(new DestinationCityBean());
                data.setCitycount(data.getCitycount()+1);
            }
            this.mData = data;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mData != null ? mData.getCitycount() + mData.getCountrycount() : 0;
    }

    @Override
    public Object getItem(int position) {
        if (mData.getCitylist().get(0).getFlag() == 0) {
            return mData.getCountrylist().get(position);
        } else {
            return mData.getCountrylist().get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.getCountrycount() != 0) {
            if (position < mData.getCitycount()) {
                return mData.getCitylist().get(position).getFlag();
            } else if (position < mData.getCitycount() + mData.getCountrycount()) {
                Log.e("jcp", "getItemViewType: " + position + "--num>" + mData.getCitycount() + mData.getCountrycount());
                return mData.getCountrylist().get(position - mData.getCitycount()).getFlag();
            }
        } else {
            return mData.getCitylist().get(position).getFlag();
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return layoutIds.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseListViewAdapter.ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(layoutIds[getItemViewType(position)], parent, false);
            holder = new BaseListViewAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((BaseListViewAdapter.ViewHolder) convertView.getTag());
        }
        switch (getItemViewType(position)) {
            case 0:
                holder.setText(R.id.destination_cnname, mData.getCitylist().get(position).getCnname());
                holder.setText(R.id.destination_enname, mData.getCitylist().get(position).getEnname());
                Log.e(TAG, "url_getView: " + mData.getCitylist().size());
                Log.e(TAG, "url_getView: " + position +"=="+mData.getCitylist().get(3).getPhoto());
                holder.setImage(context, R.id.destination_card_image, mData.getCitylist().get(position).getPhoto());
                if (position == mData.getCitycount() - 1) {
                    Log.e(TAG, "getView: " + position);
                    if (position % 2 == 0) {

                    }
                }
                break;
            case 1:
                int i = position - mData.getCitycount();
                holder.setText(R.id.destination_country_cnname, mData.getCountrylist().get(i).getCnname());
                holder.setText(R.id.destination_country_enname, mData.getCountrylist().get(i).getEnname());
                holder.setImage(context, R.id.destination_country_image, mData.getCountrylist().get(i).getPhoto());
                break;
        }

        return convertView;
    }

    public static class ViewHolder {
        private View initView;
        private Map<Integer, View> cacheViews;

        public ViewHolder(View initView) {
            this.initView = initView;
            cacheViews = new HashMap<>();
        }

        public View findView(int resId) {
            View view = null;
            if (cacheViews.containsKey(resId)) {
                view = cacheViews.get(resId);
            } else {
                view = initView.findViewById(resId);
                cacheViews.put(resId, view);
            }
            return view;
        }

        public void setText(int resId, String text) {
            ((TextView) findView(resId)).setText(text);
        }

        public void setImage(Context context, int resId, String imagePath) {
            ImageView imageView = (ImageView) findView(resId);
            if (imagePath == null || imagePath.equals("")) {
            } else {
                Picasso.with(context).load(imagePath).into(imageView);
            }

        }


    }

}
