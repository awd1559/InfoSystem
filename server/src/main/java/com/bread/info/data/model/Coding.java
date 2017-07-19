package com.bread.info.data.model;

import com.bread.info.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="is_coding")
public class Coding {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    @ManyToOne
    private CodingCategory category;

    @NotNull
    private String tag;

    //Html or md
    @NotNull
    private String description;

    private String language;

    private String author;

    //Links
    private String homelink;

    private String doclink;

    private String sourcelink;

    //oschina最后更新
    private Long osLastUpdate;
    //oschina评分
    private Float osRankCount;
    //oschina收藏数
    private Integer osFavCount;
    //oschina评论数
    private Integer osCommentCount;

    //Git
    private Integer gitStar;
    private Integer gitFork;
    //最后更新时间
    private Long gitLastUpdate;

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public CodingCategory getCategory() {
        return category;
    }

    public void setCategory(CodingCategory category) {
        this.category = category;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHomelink() {
        return homelink;
    }

    public void setHomelink(String homelink) {
        this.homelink = homelink;
    }

    public String getDoclink() {
        return doclink;
    }

    public void setDoclink(String doclink) {
        this.doclink = doclink;
    }

    public String getSourcelink() {
        return sourcelink;
    }

    public void setSourcelink(String sourcelink) {
        this.sourcelink = sourcelink;
    }

    public Long getOsLastUpdate() {
        return osLastUpdate;
    }

    public void setOsLastUpdate(Long osLastUpdate) {
        this.osLastUpdate = osLastUpdate;
    }

    public Float getOsRankCount() {
        return osRankCount;
    }

    public void setOsRankCount(Float osRankCount) {
        this.osRankCount = osRankCount;
    }

    public Integer getOsFavCount() {
        return osFavCount;
    }

    public void setOsFavCount(Integer osFavCount) {
        this.osFavCount = osFavCount;
    }

    public Integer getOsCommentCount() {
        return osCommentCount;
    }

    public void setOsCommentCount(Integer osCommentCount) {
        this.osCommentCount = osCommentCount;
    }

    public Integer getGitStar() {
        return gitStar;
    }

    public void setGitStar(Integer gitStar) {
        this.gitStar = gitStar;
    }

    public Integer getGitFork() {
        return gitFork;
    }

    public void setGitFork(Integer gitFork) {
        this.gitFork = gitFork;
    }

    public Long getGitLastUpdate() {
        return gitLastUpdate;
    }

    public void setGitLastUpdate(Long gitLastUpdate) {
        this.gitLastUpdate = gitLastUpdate;
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
