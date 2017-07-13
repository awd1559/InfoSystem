package com.bread.info.data.repository;

import com.bread.info.data.model.Note;
import com.bread.info.data.model.Study;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, String> {
    @Query("select bean from Note bean  where bean.category.id = :category_id")
    List<Note> findByCategoryId(@Param("category_id") String categoryId, Pageable page);
}
