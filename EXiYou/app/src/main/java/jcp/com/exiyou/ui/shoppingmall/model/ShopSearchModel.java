package jcp.com.exiyou.ui.shoppingmall.model;

import jcp.com.exiyou.api.Api;
import jcp.com.exiyou.base.event.AndroidIOToMain;
import jcp.com.exiyou.constants.HttpParams;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Observable;


public class ShopSearchModel implements ShopContract.ShopSearchModel {

    @Override
    public Observable<ShopSearchListBean> getShopSearchRes(String stg_id, String page) {

        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return  Api.getApiService().getShopSearchRes(stg_id,page).compose(new AndroidIOToMain.IOToMainTransformer<ShopSearchListBean>());

    }

    @Override
    public Observable<ShopSearchListBean> getShopSearchRes3(String stg_id, String page, String city_id, int order) {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return  Api.getApiService().getShopSearchRes3(stg_id,page,city_id,order).compose(new AndroidIOToMain.IOToMainTransformer<ShopSearchListBean>());

    }

    @Override
    public Observable<ShopSearchListBean> getShopSearchRes4(String stg_id, String page, int order) {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return  Api.getApiService().getShopSearchRes4(stg_id,page,order).compose(new AndroidIOToMain.IOToMainTransformer<ShopSearchListBean>());

    }

    @Override
    public Observable<ShopSearchListBean> getShopSearchRes2(String stg_id, String page, String city_id) {
        Api.setApiService(HttpParams.SHOP_HOSTNAME);
        return  Api.getApiService().getShopSearchRes2(stg_id,page,city_id).compose(new AndroidIOToMain.IOToMainTransformer<ShopSearchListBean>());
    }
}
