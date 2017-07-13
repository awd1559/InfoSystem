package com.bread.info.data.model;

import com.bread.info.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="is_coding_category")
public class CodingCategory {
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

    public CodingCategory() { this.subject = ""; }
    public CodingCategory(String subject) {
        this.subject = subject;
    }
    public CodingCategory(String subject, CodingCategory parent) {
        this.subject = subject;
        this.parent = parent;
    }

    @NotNull
    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name="parent_id")
    private CodingCategory parent;
    public CodingCategory getParent(CodingCategory parent) {
        return parent;
    }
    public void setParent(CodingCategory parent) {
        this.parent = parent;
    }


    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Set<CodingCategory> children = new HashSet<CodingCategory>();
    public Set<CodingCategory> getChildren() {
        return children;
    }
    public void setChildren(Set<CodingCategory> children) {
        this.children = children;
    }

    private Date when_created;
    public Date getWhen_created() {
        return when_created;
    }
    @JsonSerialize(using = CustomDateSerializer.class)
    public void setWhen_created(Date when_created) {
        this.when_created = when_created;
    }


    private Date when_updated;
    public Date getWhen_updated() {
        return when_updated;
    }
    @JsonSerialize(using = CustomDateSerializer.class)
    public void setWhen_updated(Date when_updated) {
        this.when_updated = when_updated;
    }


}
