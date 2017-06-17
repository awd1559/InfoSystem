package com.bread.info.models;

import com.bread.info.find.StudyCategoryFinder;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="IS_StudyCategory")
public class StudyCategory extends BaseModel {
    public static final StudyCategoryFinder find = new StudyCategoryFinder();

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
