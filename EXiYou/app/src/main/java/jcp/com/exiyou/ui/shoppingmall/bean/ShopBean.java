package jcp.com.exiyou.ui.shoppingmall.bean;

import java.util.List;


public class ShopBean {

    private List<ShopHotArea> hot_area;

//    private List<ShopSlice> slice;

    private List<ShopDisCountTopic> discount_topic;

    private List<ShopMarketTopic> market_topic;

    private List<ShopIconList> icon_list;

    private List<ShopSubIconList> sub_icon_list;

    public List<ShopHotArea> getHot_area() {
        return hot_area;
    }

    public void setHot_area(List<ShopHotArea> hot_area) {
        this.hot_area = hot_area;
    }
//
//    public List<ShopSlice> getSlice() {
//        return slice;
//    }
//
//    public void setSlice(List<ShopSlice> slice) {
//        this.slice = slice;
//    }

    public List<ShopDisCountTopic> getDiscount_topic() {
        return discount_topic;
    }

    public void setDiscount_topic(List<ShopDisCountTopic> discount_topic) {
        this.discount_topic = discount_topic;
    }


    public List<ShopMarketTopic> getMarket_topic() {
        return market_topic;
    }

    public void setMarket_topic(List<ShopMarketTopic> market_topic) {
        this.market_topic = market_topic;
    }

    public List<ShopIconList> getIcon_list() {
        return icon_list;
    }

    public void setIcon_list(List<ShopIconList> icon_list) {
        this.icon_list = icon_list;
    }

    public List<ShopSubIconList> getSub_icon_list() {
        return sub_icon_list;
    }

    public void setSub_icon_list(List<ShopSubIconList> sub_icon_list) {
        this.sub_icon_list = sub_icon_list;
    }

    public class ShopHotArea {
        private String type;
        private List<ShopHotAreaPlace> place;
        private List<ShopHotAreaList> list;

        public List<ShopHotAreaList> getList() {
            return list;
        }

        public void setList(List<ShopHotAreaList> list) {
            this.list = list;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ShopHotAreaPlace> getPlace() {
            return place;
        }

        public void setPlace(List<ShopHotAreaPlace> place) {
            this.place = place;
        }

        public class ShopHotAreaPlace {
            private String id;
            private String name;
            private String photo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public class ShopHotAreaList {
            private String id;
            private String title;
            private String price;
            private String sold;
            private String area;
            private String photo;

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

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }

//    public class ShopSlice {
//        private String cover;
//        private String title;
//        private String url;
//        private String type;
//
//        public String getCover() {
//            return cover;
//        }
//
//        public void setCover(String cover) {
//            this.cover = cover;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//    }

    public class ShopDisCountTopic {
        private ShopDisCountTopicTopic topic;
        private List<ShopTopicList> list;

        public ShopDisCountTopicTopic getTopic() {
            return topic;
        }

        public void setTopic(ShopDisCountTopicTopic topic) {
            this.topic = topic;
        }

        public List<ShopTopicList> getList() {
            return list;
        }

        public void setList(List<ShopTopicList> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "ShopDisCountTopic{" +
                    "topic=" + topic +
                    ", list=" + list +
                    '}';
        }

        public class ShopTopicList {
            private String id;
            private String title;
            private String price;
            private String sold;
            private String area;
            private String photo;

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

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            @Override
            public String toString() {
                return "ShopTopicList{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", price='" + price + '\'' +
                        ", sold='" + sold + '\'' +
                        ", area='" + area + '\'' +
                        ", photo='" + photo + '\'' +
                        '}';
            }
        }

        public class ShopDisCountTopicTopic {
            private String title;
            private String link_url;
            private String photo;

            @Override
            public String toString() {
                return "ShopDisCountTopicTopic{" +
                        "title='" + title + '\'' +
                        ", link_url='" + link_url + '\'' +
                        ", photo='" + photo + '\'' +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }


    public class ShopMarketTopic {
        private String pic;
        private String url;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class ShopIconList {
        private String icon_pic;
        private String icon;
        private String icon_type;
        private String link_url;
        private String stg_id;

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

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getStg_id() {
            return stg_id;
        }

        public void setStg_id(String stg_id) {
            this.stg_id = stg_id;
        }
    }

    public class ShopSubIconList {
        private String title;
        private String cover;
        private String idvalue;
        private String sub_title;

        public String getIdvalue() {
            return idvalue;
        }

        public void setIdvalue(String idvalue) {
            this.idvalue = idvalue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }
    }
}
