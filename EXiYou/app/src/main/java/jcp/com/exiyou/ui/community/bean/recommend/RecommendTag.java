package jcp.com.exiyou.ui.community.bean.recommend;

/**
 * Created by SweetDream on 2017/3/25.
 */
public class RecommendTag {

    private String icon_type;
    private String tag_name;
    private String tag_cover;
    private int sub_id;

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getIcon_type() {
        return icon_type;
    }

    public void setIcon_type(String icon_type) {
        this.icon_type = icon_type;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_cover() {
        return tag_cover;
    }

    public void setTag_cover(String tag_cover) {
        this.tag_cover = tag_cover;
    }
}
