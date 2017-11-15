package jcp.com.exiyou.ui.splash.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.ui.splash.adapters.GuideViewPagerAdapter;
import jcp.com.exiyou.utils.ImageUtil;


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

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    @BindView(R2.id.guide_go)
    ImageView guide_go;
    @BindView(R2.id.guide_viewpager)
    ViewPager guide_viewpager;
    @BindView(R2.id.guide_text2)
    ImageView guide_text;
   @BindView(R2.id.guide_text_logo)
    ImageView guide_text_logo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        guide_viewpager.setAdapter(new GuideViewPagerAdapter(this));
        guide_viewpager.setOnPageChangeListener(this);
        guide_text.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.bg_about_qyer_text1));
        guide_text_logo.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.exiyou_text_logo1,1));
        play(guide_viewpager, 1.1f, 1);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == guide_viewpager.getAdapter().getCount() - 4) {
            guide_go.setVisibility(View.GONE);
            guide_text.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.bg_about_qyer_text1));
            guide_text_logo.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.exiyou_text_logo1,1));
            play(guide_viewpager, 1.1f, 1);
        } else if (position == guide_viewpager.getAdapter().getCount() - 3) {
            guide_go.setVisibility(View.GONE);
            guide_text.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.bg_about_qyer_text2));
            guide_text_logo.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.exiyou_text_logo2,1));
            play(guide_viewpager, 1, 1.1f);
        } else if (position == guide_viewpager.getAdapter().getCount() - 2) {
            guide_go.setVisibility(View.GONE);
            guide_text.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.bg_about_qyer_text3));
            guide_text_logo.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.exiyou_text_logo3,1));
            play(guide_viewpager, 1.1f, 1);
        } else if (position == guide_viewpager.getAdapter().getCount() - 1) {
            guide_text.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.bg_about_qyer_text4));
            guide_text_logo.setImageBitmap(ImageUtil.sample2Image(this,R.mipmap.exiyou_text_logo4,1));
//            guide_text.setImageDrawable(getResources().getDrawable(R.mipmap.bg_about_qyer_text4));
//            guide_text_logo.setImageDrawable(getResources().getDrawable(R.mipmap.exiyou_text_logo4));
            play(guide_viewpager,  1, 1.1f);
            guide_go.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void play(View view, float x1, float x2) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,
                "ScaleX", x1, x2);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view,
                "ScaleY", x1, x2);
        animator.setDuration(2000);
        animator2.setDuration(2000);
        set.play(animator).with(animator2);
        set.start();

    }
    @OnClick(R2.id.guide_go)
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.guide_go:
                SharedPreferences sharedPreferences = this.getSharedPreferences("check", MODE_PRIVATE);
                 SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("frist", false);
//		editor.commit();
                editor.apply();//最新推荐使用apply
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


}
