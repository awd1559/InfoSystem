package com.bread.info.data.repository;

import com.bread.info.data.model.Study;
import com.bread.info.data.model.StudyCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudyRepository extends JpaRepository<Study, String> {

    @Query("select bean from Study bean  where bean.category.id = :category_id")
    List<Study> findByCategoryId(@Param("category_id") String categoryId, Pageable page);
}
