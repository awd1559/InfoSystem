package com.bread.info.models;

import com.bread.info.find.StudyFinder;
import io.ebean.annotation.NotNull;

import javax.persistence.*;

/**
 * Created by awd on 2017/6/7.
 */

@Entity
@Table(name="IS_Study")
public class Study extends BaseModel{
    public static final StudyFinder find = new StudyFinder();

    @ManyToOne
    private StudyCategory category;

    @NotNull
    private String title;
    private String description;


    public StudyCategory getCategory() {
        return category;
    }

    public void setCategory(StudyCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
