package com.bread.info.models;


import com.bread.info.find.NoteFinder;
import io.ebean.annotation.NotNull;

import javax.persistence.*;

@Entity
@Table(name="IS_Note")
public class Note extends BaseModel {
    public static final NoteFinder find = new NoteFinder();

    @NotNull
    private String title;

    @NotNull
    private String body;

    private String tag;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
