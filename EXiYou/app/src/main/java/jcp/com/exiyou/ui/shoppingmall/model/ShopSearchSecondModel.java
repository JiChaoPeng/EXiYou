package jcp.com.exiyou.ui.shoppingmall.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Observable;


public class ShopSearchSecondModel implements ShopContract.ShopSearchSecondModel {

    @Override
    public Observable<ShopSearchSecondListBean> getShopSearchSecond(String keyword) {

        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return Api.getApiService().getShopSearchSecondPageRes(keyword).compose(new AndroidIOToMain.IOToMainTransformer<ShopSearchSecondListBean>());
    }
}
