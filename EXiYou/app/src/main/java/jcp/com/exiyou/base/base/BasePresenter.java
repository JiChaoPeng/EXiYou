package jcp.com.exiyou.base.base;

/**
 * Created by SweetDream on 2017/3/24.
 */

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    public M mModel;
    public V mView;

    public BasePresenter() {

    }

    public void setMV(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }
}
