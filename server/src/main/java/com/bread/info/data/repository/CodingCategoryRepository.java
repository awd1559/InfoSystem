package com.bread.info.data.repository;

import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodingCategoryRepository extends JpaRepository<CodingCategory, String> {
    List<CodingCategory> findByParentNull();
    List<CodingCategory> findBySubject(String name);
    List<CodingCategory> findBySubjectAndParent(String subject, CodingCategory parent);
}
