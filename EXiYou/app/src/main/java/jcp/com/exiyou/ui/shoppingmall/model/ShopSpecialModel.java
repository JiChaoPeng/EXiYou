package jcp.com.exiyou.ui.shoppingmall.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSpecialListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Observable;


public class ShopSpecialModel extends BasePresenter implements ShopContract.ShopSpecialModel {

    public static final String TAG = ShopSpecialModel.class.getSimpleName();
    @Override
    public Observable<ShopSpecialListBean> getShopSpecialRes(String type) {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return Api.getApiService().getShopSpecialRes(type).compose(new AndroidIOToMain.IOToMainTransformer<ShopSpecialListBean>());
    }
}
