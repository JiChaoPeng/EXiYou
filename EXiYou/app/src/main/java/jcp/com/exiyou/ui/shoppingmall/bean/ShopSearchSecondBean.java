package jcp.com.exiyou.ui.shoppingmall.bean;

import java.util.List;


public class ShopSearchSecondBean {

    private List<ShopSearchSecondIconList> icon_list;

    private List<ShopSearchSecondSubIconList> sub_icon_list;

    private String total;

    private List<ShopSearchSecondList> list;

    private ShopSearchSecondFilters filters;

    public List<ShopSearchSecondIconList> getIcon_list() {
        return icon_list;
    }

    public void setIcon_list(List<ShopSearchSecondIconList> icon_list) {
        this.icon_list = icon_list;
    }

    public List<ShopSearchSecondSubIconList> getSub_icon_list() {
        return sub_icon_list;
    }

    public void setSub_icon_list(List<ShopSearchSecondSubIconList> sub_icon_list) {
        this.sub_icon_list = sub_icon_list;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ShopSearchSecondList> getList() {
        return list;
    }

    public void setList(List<ShopSearchSecondList> list) {
        this.list = list;
    }

    public ShopSearchSecondFilters getFilters() {
        return filters;
    }

    public void setFilters(ShopSearchSecondFilters filters) {
        this.filters = filters;
    }

    public class ShopSearchSecondSubIconList {
        private String link_url;
        private String icon;
        private String icon_type;
        private String stg_id;
        private String city_id;
        private String icon_pic;

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getIcon_pic() {
            return icon_pic;
        }

        public void setIcon_pic(String icon_pic) {
            this.icon_pic = icon_pic;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon_type() {
            return icon_type;
        }

        public void setIcon_type(String icon_type) {
            this.icon_type = icon_type;
        }

        public String getStg_id() {
            return stg_id;
        }

        public void setStg_id(String stg_id) {
            this.stg_id = stg_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

    }

    public class ShopSearchSecondIconList {
        private String link_url;
        private String icon;
        private String icon_type;
        private String stg_id;
        private String city_id;
        private String icon_pic;

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getIcon_pic() {
            return icon_pic;
        }

        public void setIcon_pic(String icon_pic) {
            this.icon_pic = icon_pic;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon_type() {
            return icon_type;
        }

        public void setIcon_type(String icon_type) {
            this.icon_type = icon_type;
        }

        public String getStg_id() {
            return stg_id;
        }

        public void setStg_id(String stg_id) {
            this.stg_id = stg_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

    }

    public class ShopSearchSecondList {
        private String id;
        private String title;
        private String price;
        private String priceoff;
        private String sold;
        private String mark;
        private String photo;
        private String url;

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

        public String getPriceoff() {
            return priceoff;
        }

        public void setPriceoff(String priceoff) {
            this.priceoff = priceoff;
        }

        public String getSold() {
            return sold;
        }

        public void setSold(String sold) {
            this.sold = sold;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class ShopSearchSecondFilters {

//        private

    }
}
