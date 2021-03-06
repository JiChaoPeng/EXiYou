package jcp.com.exiyou.base.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by SweetDream on 2017/3/17.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder> {

    private List<T> data;
    private LayoutInflater mInflater;
    private int[] layoutId;
    private Map<Integer, Integer> layoutMap;
    private int index;
    private String mType;

    public BaseRecyclerAdapter(Context context, String mType, List<T> data, int... layoutId) {
        mInflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.mType = mType;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        layoutMap = new HashMap<>();
    }

    public void addRes(List<T> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<T> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public T getItem(int position) {
        return data.get(position);
    }

    private int getType(int position) {
        int type = 0;
        T t = data.get(position);
        Class<?> cls = t.getClass();
        if (mType != null) {
            try {
                Field field = cls.getDeclaredField(mType);
                field.setAccessible(true);
                type = field.getInt(t);
                return type;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return type;
    }

    @Override
    public int getItemViewType(int position) {
        if (!layoutMap.containsKey(getType(position))) {
            layoutMap.put(getType(position), layoutId[index++]);
        }
        return getType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = mInflater.inflate(layoutMap.get(viewType), parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        loadData(holder, getItem(position), position);
    }

    protected abstract void loadData(ViewHolder holder, T item, int position);

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Map<Integer, View> cacheView;

        public ViewHolder(View itemView) {
            super(itemView);
            cacheView = new HashMap<>();
        }

        public View findView(int resId) {
            View view = null;
            if (cacheView.containsKey(resId)) {
                view = cacheView.get(resId);
            } else {
                view = itemView.findViewById(resId);
                cacheView.put(resId, view);
            }
            return view;
        }

        public void setText(int resId, String text) {
            ((TextView) findView(resId)).setText(text);
        }

    }
}
