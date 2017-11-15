package jcp.com.exiyou.ui.community.bean.enterinto;

import java.util.List;

/**
 * Created by SweetDream on 2017/3/29.
 */
public class ForumListBean {

    private int id;
    private String name;
    private List<GroupBean> group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupBean> getGroup() {
        return group;
    }

    public void setGroup(List<GroupBean> group) {
        this.group = group;
    }
}
