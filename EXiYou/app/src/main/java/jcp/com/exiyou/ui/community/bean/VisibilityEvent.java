package jcp.com.exiyou.ui.community.bean;

/**
 * Created by SweetDream on 2017/3/31.
 */

public class VisibilityEvent {

    private int firstVisibleItem;
    private boolean isTop;

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public int getFirstVisibleItem() {
        return firstVisibleItem;
    }

    public void setFirstVisibleItem(int firstVisibleItem) {
        this.firstVisibleItem = firstVisibleItem;
    }
}
