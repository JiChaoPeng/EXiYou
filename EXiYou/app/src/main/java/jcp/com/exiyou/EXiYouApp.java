package jcp.com.exiyou;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.squareup.picasso.Picasso;


public class EXiYouApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化ImageLoader
        initImageLoader();
        // 初始化Picasso
        initPicasso();
    }
    private void initImageLoader() {
        DisplayImageOptions imageOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.mipmap.ic_qyer_gray_120)
                .showImageOnFail(R.mipmap.ic_qyer_gray_120)
                .displayer(new CircleBitmapDisplayer())
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(imageOptions)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
    private void initPicasso() {
        Picasso picasso = new Picasso.Builder(this)
//                .defaultBitmapConfig(Bitmap.Config.ARGB_4444)
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
