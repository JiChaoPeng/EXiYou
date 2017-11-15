package jcp.com.exiyou.base.adapters;

import android.support.v7.widget.RecyclerView;

/**
 * Created by SweetDream on 2017/3/25.
 */

public abstract class RecyclerOnScroll extends RecyclerView.OnScrollListener {

    private boolean isEnd;
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (!recyclerView.canScrollVertically(1)) {
            isEnd = !recyclerView.canScrollVertically(1);
            onScrollListener(isEnd);
        }
    }

    public abstract void onScrollListener(boolean isEnd);
}
