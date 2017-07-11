package com.bread.info.data.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table(name="IS_Study_Category")
public class StudyCategory {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @Column(columnDefinition = "BINARY(20)")
//    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDBinaryType")
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
