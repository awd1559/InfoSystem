package com.bread.info.find;

import com.bread.info.models.Coding;
import com.bread.info.models.query.QCoding;
import io.ebean.Finder;

public class CodingFinder extends Finder<Long, Coding> {
    public CodingFinder() {
        super(Coding.class);
    }

    public CodingFinder(String serverName) {
        super(Coding.class, serverName);
    }

    public QCoding where() {
        return new QCoding(db());
    }

    public QCoding text() {
        return new QCoding(db()).text();
    }

    public QCoding select(String properties) {
        return where().select(properties);
    }
}
