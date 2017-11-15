package jcp.com.exiyou.ui.splash.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.adapters.BaseFragmentPagerAdapter;
import jcp.com.exiyou.base.base.BaseActivity;
import jcp.com.exiyou.ui.login.LoginActivity;
import jcp.com.exiyou.ui.splash.contract.MainConstants;
import jcp.com.exiyou.ui.splash.model.MainModel;
import jcp.com.exiyou.ui.splash.presenter.MainPresenter;

/**
 * Created by 超鹏 on 2017/3/25.
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


public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainConstants.MainView, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R2.id.main_hotel_user)
    ImageView main_hotel_user;
    @BindView(R2.id.main_hotel_tablayout)
    TabLayout mTabLayout;
    @BindView(R2.id.main_viewpager)
    ViewPager mViewPager;
    //双击退出的标志位
    private boolean isExit;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);
    }
    private List<String> titles1 = new ArrayList<>();
    private List<Fragment> fragments1 = new ArrayList<>();

    @Override
    public void initView() {
        getTitles();
        getFragments();
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);//ViewPager与Toolbar进行联动
        main_hotel_user.setOnClickListener(this);
    }

    private void getFragments() {
        mPresenter.getFragmentList();
    }
    private void getTitles() {
        mPresenter.getTitleList();
    }

    @Override
    public void returnTitleList(List<String> titles) {
        Log.e(TAG, "returnTitleList: " + titles);
        this.titles1 = titles;
    }
    @Override
    public void returnFragmentList(List<Fragment> fragments) {//返回数据的地方
        Log.e(TAG, "returnFragmentList: " + fragments);
        this.fragments1 = fragments;
        mViewPager.setCurrentItem(2);
        mViewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments1, titles1));
    }


    @Override
    public void OnStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_hotel_user:
                startActivity(new Intent(this, LoginActivity.class));

                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * 当菜单显示的时候,点击返回,隐藏菜单
         * 点击提示 再按一次退出
         *  1.监听返回键
         *  2.
         */
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //条件
            if (!isExit) {
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
                isExit = true;
                //还原状态
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    //    private Handler handler = new Handler(this);
    //
    //    @Override
    //    public boolean handleMessage(Message msg) {
    //        switch (msg.what){
    //            case BIND_ADAPTER:
    ////                mViewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(),fragments,titles1));
    //                break;
    //        }
    //        return true;
    //    }

}


