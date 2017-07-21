package com.bread.info.controller;

import com.bread.info.data.repository.CodingCategoryRepository;
import com.bread.info.data.repository.CodingRepository;
import com.bread.info.spider.OSChinaJsoupProcessor;
import com.bread.info.spider.OSChinaPageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.io.IOException;
import java.util.List;

@Controller
public class SpiderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private CodingRepository codingRepository;
    @Autowired
    private CodingCategoryRepository codingCategoryRepository;

    @GetMapping(path = "/spider/oschina")
    public void startScanOSChina() {
        OSChinaJsoupProcessor processor = new OSChinaJsoupProcessor(codingRepository, codingCategoryRepository);

        processor.run();
    }
}





