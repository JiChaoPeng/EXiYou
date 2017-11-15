package jcp.com.exiyou.ui.community.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.community.bean.enterintodetails.DetailsBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoDetailsContract;
import rx.Observable;

/**
 * Created by SweetDream on 2017/3/30.
 */

public class EnterIntoDetailsModel implements EnterIntoDetailsContract.Model {

    @Override
    public Observable<DetailsBean> getEnterIntoDetailsRes(int id, String type, int page) {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return Api.getApiService().getEnterIntoDetailsRes(id, type, page)
                .compose(new AndroidIOToMain.IOToMainTransformer<DetailsBean>());
    }
}
