package jcp.com.exiyou.ui.shoppingmall.presenter;

import android.util.Log;

import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import rx.Subscriber;


public class ShopSearchSecondPresenter extends ShopContract.ShopSearchSecondPresenter{
    private static final String TAG = ShopSearchSecondPresenter.class.getSimpleName();

    @Override
    public void getShopSearchSecondRes(String keyword) {
        mModel.getShopSearchSecond(keyword).subscribe(new Subscriber<ShopSearchSecondListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ShopSearchSecondListBean" + e.getMessage());
            }

            @Override
            public void onNext(ShopSearchSecondListBean shopSearchSecondListBean) {
                Log.e(TAG, "onNext: icon" + shopSearchSecondListBean.getData().getIcon_list().size());
                Log.e(TAG, "onNext: sub_icon" + shopSearchSecondListBean.getData().getSub_icon_list().size() );
                Log.e(TAG, "onNext: list" + shopSearchSecondListBean.getData().getList().size() );
                mView.returnShopSearchSecondData(shopSearchSecondListBean);
            }
        });
    }
}
