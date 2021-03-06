package jcp.com.exiyou.ui.destination.activity;

import android.net.http.SslError;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseActivity;

public class DestinationActivity extends AppCompatActivity implements View.OnClickListener {
   @BindView(R2.id.destination_web_view)
    WebView webView;
    @BindView(R2.id.activity_recommend_jump_back)
    ImageView back;
    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        url = getIntent().getStringExtra("url");
        back.setOnClickListener(this);
        //打开网页时不调用系统浏览器，而是在本WebView中显示
//        if (url.length()<15){
//            url="http://app.vmoiver.com/"+url+"&&qingapp=app_new";
//        }
        webView.loadUrl(url);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);  //支持js
//        settings.setSupportZoom(true);  //支持缩放，默认为true。是下面那个的前提。
//        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。
//        //若上面是false，则该WebView不可缩放，这个不管设置什么都不能缩放。
//        settings.setTextZoom(2);//设置文本的缩放倍数，默认为 100
        settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        settings.setLoadsImagesAutomatically(true);  //支持自动加载图片
        settings.setDefaultTextEncodingName("utf-8");//设置编码格式
        settings.setAllowFileAccess(true);  //设置可以访问文件
        settings.setNeedInitialFocus(true); //当webview调用requestFocus时为webview设置节点
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);//访问 loadUrl
                return true;
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_recommend_jump_back:
                finish();
                break;


        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  // goBack()表示返回WebView的上一页面

            webView.goBack();

            //退出全屏

            return true;

        } else {

            //结束当前页
            return super.onKeyDown(keyCode, event);
        }
    }
}
