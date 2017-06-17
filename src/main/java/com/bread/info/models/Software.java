package com.bread.info.models;


import com.bread.info.find.SoftwareFinder;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IS_Software")
public class Software extends BaseModel{
    public static final SoftwareFinder find = new SoftwareFinder();

    //分类
    @NotNull
    private String category;

    //平台
    private String platform;

    //软件名称
    @NotNull
    private String name;

    //html or md
    private String description;

    private String tag;

    //主页
    private String homelink;

    //open source 的链接
    private String oslink;

    //作者
    private String author;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getHomelink() {
        return homelink;
    }

    public void setHomelink(String homelink) {
        this.homelink = homelink;
    }

    public String getOslink() {
        return oslink;
    }

    public void setOslink(String oslink) {
        this.oslink = oslink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
