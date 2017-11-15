package jcp.com.exiyou.ui.homepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import jcp.com.exiyou.ui.destination.activity.DestinationActivity;
import jcp.com.exiyou.ui.homepage.HomePageEnentBus;

/**
 * Created by 超鹏 on 2017/3/29.
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

public class HomeViewPagerAdapter extends PagerAdapter implements View.OnClickListener {
    private static final String TAG = HomeViewPagerAdapter.class.getSimpleName();
    private List<ImageView> data;
    private Context context;
    public HomeViewPagerAdapter(Context context,List<ImageView> data) {
        this.context=context;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }

    }

    @Override
    public int getCount() {
//        return data!=null?data.size()*300:0;
        return data != null ? data.size() : 0;
    }

    public void upDate(List<ImageView> data) {
        Log.e("kkk", "upDate: " + data.size());
        if (data.size() != 0) {
            // 初始化新的数据源
            if(this.data!=null){
                this.data.clear();
            }
            Log.e("kkk", "upDate: " + data.size());
            for (int i = 0; i < data.size() + 2; i++) {
                if (i == 0) {
                    this.data.add(0, data.get(data.size() - 1));
                } else if (i > 0 && i < data.size() + 1) {
                    this.data.add(i, data.get(i - 1));
                } else if (i == data.size() + 1) {
                    this.data.add(i, data.get(0));
                }
                Log.e("kkk", "upDate: " + this.data.size() + "--" + data.size());
            }
            notifyDataSetChanged();
        }
        Log.e("kkk", "upDate: " + this.data.size() + "--" + data.size());
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (data.size() != 0) {
            Log.e("kkk", "instantiateItem: " + data.size() + "po" + position);
            ImageView imageView = data.get(position);
            ViewGroup parent = (ViewGroup) imageView.getParent();
            if (parent != null) {
                parent.removeView(imageView);
            }
            imageView.setOnClickListener(this);
            container.addView(imageView);
            return imageView;
        } else {
            return null;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(data.get(position%data.size()));
//        container.removeView(data.get(position));
//        container.removeView((View) object);
//        if (position!=0&&position%data.size()==0){
//                container.removeAllViews();
//        }
    }

    @Override
    public void onClick(View view) {
        for (int i = 1; i < data.size()-1; i++) {
            if (data.get(i)==view){
                EventBus.getDefault().post(new HomePageEnentBus(i-1));
            }
        }
//        Intent intent = new Intent(context, DestinationActivity.class);
//        intent.putExtra("url",mHomePageAdapter.getItem(i-1).getUrl());

    }
}
