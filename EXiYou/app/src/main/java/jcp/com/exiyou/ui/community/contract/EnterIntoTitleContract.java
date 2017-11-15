package jcp.com.exiyou.ui.community.contract;

import jcp.com.exiyou.base.base.BaseModel;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.base.BaseView;
import jcp.com.exiyou.ui.community.bean.enterintotitle.TitleBean;
import jcp.com.exiyou.ui.community.bean.enterintotitle.TitleDataBean;
import rx.Observable;

/**
 * Created by SweetDream on 2017/3/30.
 */

public interface EnterIntoTitleContract {

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void requestEnterIntoTitleRes(int fid);
    }

    interface Model extends BaseModel {
        Observable<TitleBean> getEnterIntoTitleRes(int fid);
    }

    interface View extends BaseView {
        void returnEnterIntoTitleRes(TitleDataBean itemDataBean);
    }

}
