package com.bread.info.data.model;

import com.bread.info.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name="IS_Study_Category")
public class StudyCategory {

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

    public StudyCategory() { this.subject = ""; }
    public StudyCategory(String subject) {
        this.subject = subject;
    }

    @NotNull
    private String subject;

    private Date when_created;
    private Date when_updated;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

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
