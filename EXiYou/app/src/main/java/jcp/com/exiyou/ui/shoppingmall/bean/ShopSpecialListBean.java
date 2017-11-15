package jcp.com.exiyou.ui.shoppingmall.bean;

import java.util.List;


public class ShopSpecialListBean {
    private List<ShopSpecialBean> data;

    public List<ShopSpecialBean> getData() {
        return data;
    }

    public void setData(List<ShopSpecialBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShopSpecialListBean{" +
                "data=" + data +
                '}';
    }
}
