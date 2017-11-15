package jcp.com.exiyou.ui.shoppingmall.bean;

public class ShopListBean {

    private String status;
    private String info;
    private String times;
    private ShopBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public ShopBean getData() {
        return data;
    }

    public void setData(ShopBean data) {
        this.data = data;
    }
}
