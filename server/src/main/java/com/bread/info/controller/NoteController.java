package com.bread.info.controller;

import com.bread.info.data.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer PAGE_SIZE = 10;

    @Autowired
    private NoteRepository noteRepository;
}
