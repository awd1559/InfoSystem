package com.bread.info.data.repository;

import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CodingRepository extends CrudRepository<Coding, String> {
    List<Coding> findByNameAndCategory(String name, CodingCategory category);
    List<Coding> findByHomelink(String homelink);
}
