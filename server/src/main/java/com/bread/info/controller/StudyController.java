package com.bread.info.controller;

import com.bread.info.data.model.StudyCategory;
import com.bread.info.data.repository.StudyCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudyController {
    @Autowired
    private StudyCategoryRepository studyCategoryRepository;

    @GetMapping(path = "/studycategory/list")
    public @ResponseBody
    Iterable<StudyCategory> getAllStat(){
        return studyCategoryRepository.findAll();
    }

    @PostMapping(path="/studycategory/add")
    public void addStudyCategory(StudyCategory category) {
        studyCategoryRepository.save(category);
    }

}
