package com.bread.info.data.repository;

import com.bread.info.data.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, UUID> {
}
