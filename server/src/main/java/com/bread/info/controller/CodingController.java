package com.bread.info.controller;


import com.bread.info.data.model.Coding;
import com.bread.info.data.repository.CodingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/coding")
public class CodingController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private CodingRepository codingRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Coding> getAllCoding(){
        return codingRepository.findAll();
    }


    @PostMapping(path="/add")
    public void addCoding(Coding coding) {
        codingRepository.save(coding);
    }



}
