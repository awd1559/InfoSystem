package com.bread.info.data.repository;

import com.bread.info.data.model.Coding;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CodingRepository extends CrudRepository<Coding, UUID> {
}
