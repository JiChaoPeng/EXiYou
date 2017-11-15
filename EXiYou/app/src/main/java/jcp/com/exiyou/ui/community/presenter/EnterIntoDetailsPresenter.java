package jcp.com.exiyou.ui.community.presenter;

import jcp.com.exiyou.ui.community.bean.enterintodetails.DetailsBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoDetailsContract;
import rx.Observer;

/**
 * Created by SweetDream on 2017/3/30.
 */

public class EnterIntoDetailsPresenter extends EnterIntoDetailsContract.Presenter {

    @Override
    public void requestEnterIntoDetailsRes(int id, String type, int page) {
        mModel.getEnterIntoDetailsRes(id, type, page)
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError("errorInfo:"+e.getCause());
                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        mView.returnEnterIntoDetailsRes(detailsBean.getData());
                    }
                });
    }
}
