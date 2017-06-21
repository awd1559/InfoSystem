package com.bread.info.data.repository;

import com.bread.info.data.model.Study;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudyRepository extends CrudRepository<Study, UUID>{
}
