package com.bread.info.find;

import com.bread.info.models.Company;
import com.bread.info.models.query.QCompany;
import io.ebean.Finder;

/**
 * Created by awd on 2017/6/7.
 */
public class CompanyFinder extends Finder<Long, Company> {
    public CompanyFinder() {
        super(Company.class);
    }

    public CompanyFinder(String serverName) {
        super(Company.class, serverName);
    }

    public QCompany where() {
        return new QCompany(db());
    }

    public QCompany text() {
        return new QCompany(db()).text();
    }

    public QCompany select(String properties) {
        return where().select(properties);
    }
}
