package jcp.com.exiyou.ui.community.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.List;

import jcp.com.exiyou.ui.community.contract.CommunityContract;

/**
 * Created by SweetDream on 2017/3/27.
 */

public class CommunityPresenter extends CommunityContract.Presenter {
    @Override
    public void requestTitles(Context context) {
        List<String> titles = mModel.getTitles(context);
        mView.returnTitles(titles);
    }

    @Override
    public void requestFragments() {
        List<Fragment> fragments = mModel.getFragments();
        mView.returnFragments(fragments);
    }
}
