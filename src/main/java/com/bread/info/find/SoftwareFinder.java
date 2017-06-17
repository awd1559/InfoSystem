package com.bread.info.find;

import com.bread.info.models.Software;
import com.bread.info.models.query.QSoftware;
import io.ebean.Finder;

/**
 * Created by awd on 2017/6/7.
 */
public class SoftwareFinder extends Finder<Long, Software> {
    public SoftwareFinder() {
        super(Software.class);
    }

    public SoftwareFinder(String serverName) {
        super(Software.class, serverName);
    }

    public QSoftware where() {
        return new QSoftware(db());
    }

    public QSoftware text() {
        return new QSoftware(db()).text();
    }

    public QSoftware select(String properties) {
        return where().select(properties);
    }
}
