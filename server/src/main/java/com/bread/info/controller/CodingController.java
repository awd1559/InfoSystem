package com.bread.info.controller;


import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import com.bread.info.data.repository.CodingCategoryRepository;
import com.bread.info.data.repository.CodingRepository;
import com.bread.info.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CodingController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private CodingCategoryRepository codingCategoryRepository;
    
    @Autowired
    private CodingRepository codingRepository;

    //category
    @GetMapping(path = "/codingcategory/list")
    public @ResponseBody
    Iterable<CodingCategory> getCodingCategoryList(){
        return codingCategoryRepository.findByParentNull();
    }

    @GetMapping(path = "/codingcategory/one")
    public @ResponseBody
    CodingCategory getcodingCategoryById(String id) {
        return codingCategoryRepository.findOne(id);
    }

    @PostMapping(path="/codingcategory/add")
    public @ResponseBody
    CodingCategory addcodingCategory(@RequestBody CodingCategory category) {
        return codingCategoryRepository.save(category);
    }

    @PostMapping(path = "/codingcategory/update")
    public @ResponseBody
    CodingCategory updateCodingCategory(@RequestBody CodingCategory category) {
        return codingCategoryRepository.save(category);
    }

    @GetMapping(path = "/codingcategory/delete")
    public @ResponseBody
    Result deleteCodingCategory(String id) {
        codingCategoryRepository.delete(id);
        return new Result(200, "ok");
    }
    
    
    //coding
    @GetMapping(path = "/coding/all")
    public @ResponseBody
    Iterable<Coding> getAllCoding(){
        return codingRepository.findAll();
    }


    @PostMapping(path="/coding/add")
    public void addCoding(Coding coding) {
        codingRepository.save(coding);
    }



}
