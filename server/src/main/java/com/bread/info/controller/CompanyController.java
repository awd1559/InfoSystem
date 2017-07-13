package com.bread.info.controller;

import com.bread.info.data.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CompanyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private CompanyRepository companyRepository;


}
