package com.bread.info.data.repository;

import com.bread.info.data.model.StudyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudyCategoryRepository extends JpaRepository<StudyCategory, String> {
}
