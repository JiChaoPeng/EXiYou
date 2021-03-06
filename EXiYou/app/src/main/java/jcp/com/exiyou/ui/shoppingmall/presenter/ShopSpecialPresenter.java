package jcp.com.exiyou.ui.shoppingmall.presenter;

import android.util.Log;

import jcp.com.exiyou.ui.shoppingmall.bean.ShopSpecialListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Subscriber;


public class ShopSpecialPresenter extends ShopContract.ShopSpecialPresenter{
    private static final String TAG = ShopSpecialPresenter.class.getSimpleName();

    @Override
    public void getShopSpecialRes(String type) {

        mModel.getShopSpecialRes(type).subscribe(new Subscriber<ShopSpecialListBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: getShopSpecialRes" + e.getMessage() );
            }

            @Override
            public void onNext(ShopSpecialListBean shopSpecialListBean) {
                mView.returnShopSpecialData(shopSpecialListBean);

            }
        });
    }
}
