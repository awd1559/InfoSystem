package com.bread.info.data.repository;

import com.bread.info.data.model.Coding;
import com.bread.info.data.model.CodingCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CodingRepository extends CrudRepository<Coding, String> {
    Coding findByNameAndCategory(String name, CodingCategory category);
}
