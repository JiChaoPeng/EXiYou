package jcp.com.exiyou.ui.community.contract;

import java.util.List;

import jcp.com.exiyou.base.base.BaseModel;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.base.BaseView;
import jcp.com.exiyou.ui.community.bean.enterinto.EnterIntoBean;
import jcp.com.exiyou.ui.community.bean.enterinto.EnterIntoDataBean;
import rx.Observable;

/**
 * Created by SweetDream on 2017/3/29.
 */

public interface EnterIntoContract {

    abstract class Precenter extends BasePresenter<Model, View> {
        public abstract void requestEnterIntoRes();
    }

    interface Model extends BaseModel{
        Observable<EnterIntoBean> getEnterIntoRes();
    }

    interface View extends BaseView {
        void returnEnterIntoRes(EnterIntoDataBean enterIntoDataBean);
    }
}
