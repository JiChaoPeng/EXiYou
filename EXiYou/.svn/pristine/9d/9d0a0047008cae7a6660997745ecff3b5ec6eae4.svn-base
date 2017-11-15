package jcp.com.exiyou.ui.community.presenter;

import jcp.com.exiyou.ui.community.bean.enterinto.EnterIntoBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoContract;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by SweetDream on 2017/3/29.
 */

public class EnterIntoPresenter extends EnterIntoContract.Precenter {
    @Override
    public void requestEnterIntoRes() {
        mModel.getEnterIntoRes()
                .subscribe(new Subscriber<EnterIntoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError("error:" + e.getCause());
                    }

                    @Override
                    public void onNext(EnterIntoBean enterIntoBean) {
                        mView.returnEnterIntoRes(enterIntoBean.getData());
                    }
                });
    }
}
