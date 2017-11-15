package jcp.com.exiyou.ui.community.contract;

import jcp.com.exiyou.base.base.BaseModel;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.base.BaseView;
import jcp.com.exiyou.ui.community.bean.enterintodetails.DetailsBean;
import jcp.com.exiyou.ui.community.bean.enterintodetails.DetailsDataBean;
import rx.Observable;

/**
 * Created by SweetDream on 2017/3/30.
 */

public interface EnterIntoDetailsContract {

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void requestEnterIntoDetailsRes(int id, String type, int page);
    }

    interface Model extends BaseModel {
        Observable<DetailsBean> getEnterIntoDetailsRes(int id, String type, int page);
    }

    interface View extends BaseView {
        void returnEnterIntoDetailsRes(DetailsDataBean detailsDataBean);
    }
}
