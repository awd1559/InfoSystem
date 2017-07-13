package com.bread.info.controller;

import com.bread.info.data.model.Note;
import com.bread.info.data.model.NoteCategory;
import com.bread.info.data.repository.NoteCategoryRepository;
import com.bread.info.data.repository.NoteRepository;
import com.bread.info.util.Result;
import com.bread.info.util.ResultPagable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NoteController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteCategoryRepository noteCategoryRepository;

    //NoteCategory
    @GetMapping(path = "/notecategory/list")
    public @ResponseBody
    Iterable<NoteCategory> getNoteCategoryList(){
        return noteCategoryRepository.findAll();
    }

    @GetMapping(path = "/notecategory/one")
    public @ResponseBody
    NoteCategory getNoteCategoryById(String id) {
        return noteCategoryRepository.findOne(id);
    }

    @PostMapping(path="/notecategory/add")
    public @ResponseBody
    NoteCategory addNoteCategory(@RequestBody NoteCategory category) {
        logger.error(category.getId());
        logger.error(category.getSubject());
        return noteCategoryRepository.save(category);
    }

    @PostMapping(path = "/notecategory/update")
    public @ResponseBody
    NoteCategory updateStudyCategory(@RequestBody NoteCategory category) {
        return noteCategoryRepository.save(category);
    }

    @GetMapping(path = "/notecategory/delete")
    public @ResponseBody
    Result deleteStudyCategory(String id) {
        noteCategoryRepository.delete(id);
        return new Result(200, "ok");
    }



    //Stuty
    @GetMapping(path = "/note/all")
    public @ResponseBody
    Iterable<Note> getNoteAll() {
        return noteRepository.findAll();
    }

    @GetMapping(path = "/note/list")
    public @ResponseBody
    ResultPagable<Note> getNoteListById(String categoryId, int page) {
        Pageable pageable = new PageRequest(page-1, PAGE_SIZE);
        List<Note> items = noteRepository.findByCategoryId(categoryId, pageable);
        return new ResultPagable<>(items);
    }

    @GetMapping(path = "/note/one")
    public @ResponseBody
    Note getNoteById(String id) {
        return noteRepository.findOne(id);
    }

    @PostMapping(path = "/note/add")
    public @ResponseBody
    Note addNote(@RequestBody Note study) { return noteRepository.save(study);
    }

    @PostMapping(path = "/note/update")
    public @ResponseBody
    Note updateNote(@RequestBody Note study) { return noteRepository.save(study);
    }

    @PostMapping(path = "/note/delete")
    public @ResponseBody
    Result deleteNote(@RequestBody String id) {
        noteRepository.delete(id);
        return new Result(200, "ok");
    }
}
