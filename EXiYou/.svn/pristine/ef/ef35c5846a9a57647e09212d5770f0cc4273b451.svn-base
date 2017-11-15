package jcp.com.exiyou.ui.splash.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import jcp.com.exiyou.R;
import jcp.com.exiyou.utils.ImageUtil;


/**
 * Created by 超鹏 on 2017/2/24.
 */

public class GuideViewPagerAdapter extends PagerAdapter {
	private int[] data={R.mipmap.bg_about_qyer_img1,R.mipmap.bg_about_qyer_img2
			,R.mipmap.bg_about_qyer_img3,R.mipmap.bg_about_qyer_img4};
	private Context context;

	public GuideViewPagerAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView imageView=new ImageView(context);
		imageView.setImageBitmap(ImageUtil.sample2Image(context,data[position]));
		imageView.setScaleType(ScaleType.FIT_XY);
		container.addView(imageView);
		return imageView;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}

}
