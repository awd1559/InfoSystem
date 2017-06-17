package com.bread.info.find;

import com.bread.info.models.Study;
import com.bread.info.models.query.QStudy;
import io.ebean.Finder;

/**
 * Created by awd on 2017/6/7.
 */
public class StudyFinder extends Finder<Long, Study> {
    public StudyFinder() {
        super(Study.class);
    }

    public StudyFinder(String serverName) {
        super(Study.class, serverName);
    }

    public QStudy where() {
        return new QStudy(db());
    }

    public QStudy text() {
        return new QStudy(db()).text();
    }

    public QStudy select(String properties) {
        return where().select(properties);
    }
}
