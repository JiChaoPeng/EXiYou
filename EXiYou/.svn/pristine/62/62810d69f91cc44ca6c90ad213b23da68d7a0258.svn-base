package jcp.com.exiyou.ui.community.activitys;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseActivity;

public class RecommendJumpActivity extends BaseActivity {

    @BindView(R2.id.activity_recommend_jump_web)
    WebView mWeb;
    @Override
    public int getLayoutId() {
        return R.layout.activity_recommend_jump;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        String urlPath = getIntent().getStringExtra("url_path");
        mWeb.loadUrl(urlPath);
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @OnClick(value = {R2.id.activity_recommend_jump_back, R2.id.activity_recommend_jump_heart,
            R2.id.activity_recommend_jump_elevate, R2.id.activity_recommend_jump_menu})
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.activity_recommend_jump_back:
                finish();
                break;
            case R.id.activity_recommend_jump_elevate:

                break;
            case R.id.activity_recommend_jump_heart:

                break;
            case R.id.activity_recommend_jump_menu:

                break;
        }
    }
}
