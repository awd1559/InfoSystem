package com.bread.info.data.model;


import com.bread.info.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="IS_Company")
public class Company{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(20)")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    private Date when_created;
    private Date when_updated;
    @JsonSerialize(using = CustomDateSerializer.class)
    public void setWhen_created(Date when_created) {
        this.when_created = when_created;
    }

    public Date getWhen_updated() {
        return when_updated;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public void setWhen_updated(Date when_updated) {
        this.when_updated = when_updated;
    }

}
