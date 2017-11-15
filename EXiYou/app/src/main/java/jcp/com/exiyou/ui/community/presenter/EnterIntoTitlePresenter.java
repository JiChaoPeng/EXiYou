package jcp.com.exiyou.ui.community.presenter;

import jcp.com.exiyou.ui.community.bean.enterintotitle.TitleBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoTitleContract;
import rx.Observer;

/**
 * Created by SweetDream on 2017/3/30.
 */

public class EnterIntoTitlePresenter extends EnterIntoTitleContract.Presenter {

    @Override
    public void requestEnterIntoTitleRes(int fid) {
        mModel.getEnterIntoTitleRes(fid)
                .subscribe(new Observer<TitleBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError("errorInfo:" + e.getCause());
                    }

                    @Override
                    public void onNext(TitleBean itemBean) {
                        mView.returnEnterIntoTitleRes(itemBean.getData());
                    }
                });
    }
}
