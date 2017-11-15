package jcp.com.exiyou.ui.community.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.community.bean.enterintotitle.TitleBean;
import jcp.com.exiyou.ui.community.contract.EnterIntoTitleContract;
import rx.Observable;

/**
 * Created by SweetDream on 2017/3/30.
 */

public class EnterIntoTitleModel implements EnterIntoTitleContract.Model {


    @Override
    public Observable<TitleBean> getEnterIntoTitleRes(int fid) {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return Api.getApiService().getEnterIntoTitleRes(fid)
                .compose(new AndroidIOToMain.IOToMainTransformer<TitleBean>());
    }
}
