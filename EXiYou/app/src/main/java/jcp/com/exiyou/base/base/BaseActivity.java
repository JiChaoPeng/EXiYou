package jcp.com.exiyou.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import butterknife.ButterKnife;
import jcp.com.exiyou.base.util.TypeUtil;

/**
 * Created by SweetDream on 2017/3/24.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置布局前进行的操作
        doBeforeLayout();
        // 导入布局
        setContentView(getLayoutId());
        // View注入
        ButterKnife.bind(this);
        // 初始化Presenter
        mPresenter = TypeUtil.getObject(this, 0);
        // 初始化Model
        mModel = TypeUtil.getObject(this, 1);
        // 初始化View
        if (mPresenter != null) {
            initPresenter();
        }
        //初始化View
        this.initView();
    }
    protected void doBeforeLayout(){
    }

    public abstract int getLayoutId();

    public abstract void initPresenter();

    public abstract void initView();
}
