package jcp.com.exiyou.ui.splash.contract;

import android.support.v4.app.Fragment;

import java.util.List;

import jcp.com.exiyou.base.base.BaseModel;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.base.BaseView;


public interface MainConstants{

    public abstract class MainPresenter extends BasePresenter<MainModel,MainView> {
        public abstract void getTitleList();

        public abstract void getFragmentList();
    }

    interface MainModel extends BaseModel {
        List<String> getTitleList();
        List<Fragment> getFragmentList();
    }

    public interface MainView extends BaseView {

        void returnTitleList(List<String> titles);

        void returnFragmentList(List<Fragment> fragments);
    }
}
