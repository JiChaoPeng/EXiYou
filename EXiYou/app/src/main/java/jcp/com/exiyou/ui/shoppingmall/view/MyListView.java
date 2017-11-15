package jcp.com.exiyou.ui.shoppingmall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import jcp.com.exiyou.ui.citysite.activity.CityActivity;


public class MyListView extends ListView {
    public MyListView(Context context) {
        this(context,null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec((int) (Math.pow(2, 30) - 1), MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, i);
    }


}
