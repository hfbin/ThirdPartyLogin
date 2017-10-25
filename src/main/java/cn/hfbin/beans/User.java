package cn.hfbin.beans;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private Integer sex;

    private String addreas;

    private String headimgurl;

    private Date data;

    private String openid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddreas() {
        return addreas;
    }

    public void setAddreas(String addreas) {
        this.addreas = addreas == null ? null : addreas.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public User(Integer id, String name, Integer sex, String addreas, String headimgurl, Date data, String openid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.addreas = addreas;
        this.headimgurl = headimgurl;
        this.data = data;
        this.openid = openid;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", addreas='" + addreas + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", data=" + data +
                ", openid='" + openid + '\'' +
                '}';
    }
}