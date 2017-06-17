package com.bread.info.find;

import com.bread.info.models.StudyCategory;
import com.bread.info.models.query.QStudyCategory;
import io.ebean.Finder;

/**
 * Created by awd on 2017/6/7.
 */
public class StudyCategoryFinder extends Finder<Long, StudyCategory> {
    public StudyCategoryFinder() {
        super(StudyCategory.class);
    }

    public StudyCategoryFinder(String serverName) {
        super(StudyCategory.class, serverName);
    }

    public QStudyCategory where() {
        return new QStudyCategory(db());
    }

    public QStudyCategory text() {
        return new QStudyCategory(db()).text();
    }

    public QStudyCategory select(String properties) {
        return where().select(properties);
    }
}
