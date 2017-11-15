package jcp.com.exiyou.ui.community.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.community.bean.recommend.RecommendBean;
import jcp.com.exiyou.ui.community.contract.RecommendContract;
import rx.Observable;


/**
 * Created by SweetDream on 2017/3/25.
 */

public class RecommendModel implements RecommendContract.Model {

    @Override
    public Observable<RecommendBean> getRecommendRes(int page) {
//        Api api = new Api();
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return Api.getApiService().getRecommendRes(page)
                .compose(new AndroidIOToMain.IOToMainTransformer<RecommendBean>());
//        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
