package jcp.com.exiyou.ui.shoppingmall.presenter;

import android.util.Log;

import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Subscriber;


public class ShopSearchPresenter extends ShopContract.ShopSearchPresenter{

    public static final String TAG = ShopSearchPresenter.class.getSimpleName();
    @Override
    public void getShopSearchRes(String stg_id, String page) {
        mModel.getShopSearchRes(stg_id,page).subscribe(new Subscriber<ShopSearchListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: getShopSearchRes" + e.getMessage() );
            }

            @Override
            public void onNext(ShopSearchListBean shopSearchListBean) {

                mView.returnShopSearchListData(shopSearchListBean);
            }
        });
    }

    @Override
    public void getShopSearchRes2(String stg_id, String page, String city_id) {
        mModel.getShopSearchRes2(stg_id,page,city_id).subscribe(new Subscriber<ShopSearchListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShopSearchListBean shopSearchListBean) {
                mView.returnShopSearchListData(shopSearchListBean);
            }
        });
    }

    @Override
    public void getShopSearchRes3(String stg_id, String page, String city_id, int order) {
        mModel.getShopSearchRes3(stg_id,page,city_id,order).subscribe(new Subscriber<ShopSearchListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShopSearchListBean shopSearchListBean) {
                mView.returnShopSearchListData(shopSearchListBean);
            }
        });
    }

    @Override
    public void getShopSearchRes4(String stg_id, String page, int order) {
        mModel.getShopSearchRes4(stg_id,page,order).subscribe(new Subscriber<ShopSearchListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShopSearchListBean shopSearchListBean) {
                mView.returnShopSearchListData(shopSearchListBean);
            }
        });
    }
}
