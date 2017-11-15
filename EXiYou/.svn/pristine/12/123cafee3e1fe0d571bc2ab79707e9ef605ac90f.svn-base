package jcp.com.exiyou.ui.community.contract;

import jcp.com.exiyou.base.base.BaseModel;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.base.BaseView;
import jcp.com.exiyou.ui.community.bean.recommend.RecommendBean;
import jcp.com.exiyou.ui.community.bean.recommend.RecommendDataBean;
import rx.Observable;


/**
 * Created by SweetDream on 2017/3/25.
 */

public interface RecommendContract {

    public abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void requestRecommendRes(int page);
    }

    interface Model extends BaseModel {
        Observable<RecommendBean> getRecommendRes(int page);
    }

    interface View extends BaseView {
        void returnRecommendRes(RecommendDataBean recommendDataBean);
    }
}
