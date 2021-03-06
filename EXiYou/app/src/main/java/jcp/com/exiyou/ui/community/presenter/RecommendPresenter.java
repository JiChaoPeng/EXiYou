package jcp.com.exiyou.ui.community.presenter;

import jcp.com.exiyou.ui.community.bean.recommend.RecommendBean;
import jcp.com.exiyou.ui.community.contract.RecommendContract;
import rx.Observer;

/**
 * Created by SweetDream on 2017/3/25.
 */

public class RecommendPresenter extends RecommendContract.Presenter {
    @Override
    public void requestRecommendRes(int page) {
        mModel.getRecommendRes(page)
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError("errorInfo:" + e.getCause());
                    }

                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        mView.returnRecommendRes(recommendBean.getData());
                    }
                });
    }
}
