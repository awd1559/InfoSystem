package com.bread.info.controller;

import com.bread.info.data.model.Study;
import com.bread.info.data.model.StudyCategory;
import com.bread.info.data.repository.StudyCategoryRepository;
import com.bread.info.data.repository.StudyRepository;
import com.bread.info.util.Result;
import com.bread.info.util.ResultPagable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private StudyCategoryRepository studyCategoryRepository;

    @Autowired
    private StudyRepository studyRepository;

    //StucyCategory
    @GetMapping(path = "/studycategory/list")
    public @ResponseBody
    Iterable<StudyCategory> getStudyCategoryList(){
        return studyCategoryRepository.findAll();
    }

    @GetMapping(path = "/studycategory/one")
    public @ResponseBody
    StudyCategory getStudyCategoryById(String id) {
        return studyCategoryRepository.findOne(id);
    }

    @PostMapping(path="/studycategory/add")
    public @ResponseBody
    StudyCategory addStudyCategory(@RequestBody StudyCategory category) {
        logger.error(category.getId());
        logger.error(category.getSubject());
        return studyCategoryRepository.save(category);
    }

    @PostMapping(path = "/studycategory/update")
    public @ResponseBody
    StudyCategory updateStudyCategory(@RequestBody StudyCategory category) {
        return studyCategoryRepository.save(category);
    }

    @GetMapping(path = "/studycategory/delete")
    public @ResponseBody
    Result deleteStudyCategory(String id) {
        studyCategoryRepository.delete(id);
        return new Result(200, "ok");
    }



    //Stuty
    @GetMapping(path = "/study/all")
    public @ResponseBody
    Iterable<Study> getStudyAll() {
        return studyRepository.findAll();
    }

    @GetMapping(path = "/study/list")
    public @ResponseBody
    ResultPagable<Study> getStudyListById(String categoryId, int page) {
        Pageable pageable = new PageRequest(page-1, PAGE_SIZE);
        List<Study> items = studyRepository.findByCategoryId(categoryId, pageable);
        return new ResultPagable<>(items);
    }

    @GetMapping(path = "/study/one")
    public @ResponseBody
    Study getStudyById(String id) {
        return studyRepository.findOne(id);
    }

    @PostMapping(path = "/study/add")
    public @ResponseBody
    Study addStudy(@RequestBody Study study) { return studyRepository.save(study);
    }

    @PostMapping(path = "/study/update")
    public @ResponseBody
    Study updateStudy(@RequestBody Study study) { return studyRepository.save(study);
    }

    @PostMapping(path = "/study/delete")
    public @ResponseBody
    Result deleteStudy(@RequestBody String id) {
        studyRepository.delete(id);
        return new Result(200, "ok");
    }


}
