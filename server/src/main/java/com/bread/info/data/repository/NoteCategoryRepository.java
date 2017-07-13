package com.bread.info.data.repository;

import com.bread.info.data.model.NoteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteCategoryRepository extends JpaRepository<NoteCategory, String> {
}
