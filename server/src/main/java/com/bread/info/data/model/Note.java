package com.bread.info.data.model;


import com.bread.info.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="IS_Note")
public class Note {

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

    @NotNull
    private String title;

    @NotNull
    private String body;

    private String tag;

    @ManyToOne
    private NoteCategory category;

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

    public NoteCategory getCategory() {
        return category;
    }

    public void setCategory(NoteCategory category) {
        this.category = category;
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
