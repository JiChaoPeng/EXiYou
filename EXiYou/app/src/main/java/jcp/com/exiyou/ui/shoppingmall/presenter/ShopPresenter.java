package jcp.com.exiyou.ui.shoppingmall.presenter;

import android.util.Log;

import jcp.com.exiyou.ui.shoppingmall.bean.ShopListBean;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopListHotGoods;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Subscriber;


public class ShopPresenter extends ShopContract.ShopPresenter {

    private static final String TAG = ShopPresenter.class.getSimpleName();

    @Override
    public void getShopRes(int page) {

        mModel.getShopRes1(page).subscribe(new Subscriber<ShopListHotGoods>() {

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "----onError1: getShopRes1"+e.getMessage() );
                mView.onError("---errorInfo:");
            }

            @Override
            public void onNext(ShopListHotGoods shopListHotGoods) {
                mView.returnShopData(shopListHotGoods);
            }

        });
    }

    @Override
    public void getShopHeaderRes() {
        mModel.getShopHeaderRes1().subscribe(new Subscriber<ShopListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "----onError2: "+e.getMessage() );
                mView.onError("---errorInfo:");
            }

            @Override
            public void onNext(ShopListBean data) {
                Log.e(TAG, "onNext: " + data );
                mView.retrunShopHeaderRes(data);
            }
        });
    }
}
