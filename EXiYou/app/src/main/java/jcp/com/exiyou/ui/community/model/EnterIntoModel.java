package jcp.com.exiyou.ui.community.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.community.bean.enterinto.EnterIntoBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoContract;
import rx.Observable;

/**
 * Created by SweetDream on 2017/3/29.
 */

public class EnterIntoModel implements EnterIntoContract.Model{
    @Override
    public Observable<EnterIntoBean> getEnterIntoRes() {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return Api.getApiService().getEnterIntoRes()
                .compose(new AndroidIOToMain.IOToMainTransformer<EnterIntoBean>());
    }
}
