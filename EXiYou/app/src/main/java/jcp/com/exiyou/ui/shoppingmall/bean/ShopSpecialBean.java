package jcp.com.exiyou.ui.shoppingmall.bean;

import java.util.List;


public class ShopSpecialBean {

    private String area;
    private List<String> poi;
    private List<ShopSpecialList> list;

    @Override
    public String toString() {
        return "ShopSpecialBean{" +
                "area='" + area + '\'' +
                ", poi=" + poi +
                ", list=" + list +
                '}';
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<String> getPoi() {
        return poi;
    }

    public void setPoi(List<String> poi) {
        this.poi = poi;
    }

    public List<ShopSpecialList> getList() {
        return list;
    }

    public void setList(List<ShopSpecialList> list) {
        this.list = list;
    }

    public class ShopSpecialList {

        private String id;
        private String title;
        private String price;
        private String sold;
        private String photo;

        @Override
        public String toString() {
            return "ShopSpecialList{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", price='" + price + '\'' +
                    ", sold='" + sold + '\'' +
                    ", photo='" + photo + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSold() {
            return sold;
        }

        public void setSold(String sold) {
            this.sold = sold;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
