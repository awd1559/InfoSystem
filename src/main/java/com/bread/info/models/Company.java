package com.bread.info.models;


import com.bread.info.find.CompanyFinder;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IS_Company")
public class Company extends BaseModel{
    public static final CompanyFinder find = new CompanyFinder();

    //行业
    @NotNull
    private String line;

    //公司名
    @NotNull
    private String name;

    //经理
    @NotNull
    private String manager;

    //电话
    private String phone;

    //地址
    private String address;

    //网站
    private String site;



    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
