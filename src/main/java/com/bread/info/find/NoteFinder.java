package com.bread.info.find;

import com.bread.info.models.Note;
import com.bread.info.models.query.QNote;
import io.ebean.Finder;

/**
 * Created by awd on 2017/6/7.
 */
public class NoteFinder extends Finder<Long, Note> {
    public NoteFinder() {
        super(Note.class);
    }

    public NoteFinder(String serverName) {
        super(Note.class, serverName);
    }

    public QNote where() {
        return new QNote(db());
    }

    public QNote text() {
        return new QNote(db()).text();
    }

    public QNote select(String properties) {
        return where().select(properties);
    }
}
