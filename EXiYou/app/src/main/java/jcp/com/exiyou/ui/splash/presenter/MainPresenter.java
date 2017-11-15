package jcp.com.exiyou.ui.splash.presenter;

import android.support.v4.app.Fragment;

import java.util.List;

import jcp.com.exiyou.ui.splash.contract.MainConstants;

public class MainPresenter extends MainConstants.MainPresenter {

    public static final String TAG = MainPresenter.class.getSimpleName();

    @Override
    public void getTitleList() {
        List<String> titleList = mModel.getTitleList();
        mView.returnTitleList(titleList);
    }

    @Override
    public void getFragmentList() {
        List<Fragment> fragmentList = mModel.getFragmentList();
        mView.returnFragmentList(fragmentList);
    }


}
