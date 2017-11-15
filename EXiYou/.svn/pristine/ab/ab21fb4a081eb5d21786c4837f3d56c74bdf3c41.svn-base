package jcp.com.exiyou.ui.community.contract;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.List;

import jcp.com.exiyou.base.base.BaseModel;
import jcp.com.exiyou.base.base.BasePresenter;
import jcp.com.exiyou.base.base.BaseView;

/**
 * Created by SweetDream on 2017/3/27.
 */

public interface CommunityContract {

    public abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void requestTitles(Context context);
        public abstract void requestFragments();
    }

    interface Model extends BaseModel {
        List<String> getTitles(Context context);
        List<Fragment> getFragments();
    }

    interface View extends BaseView {
        void returnTitles(List<String> titles);
        void returnFragments(List<Fragment> fragments);
    }
}
