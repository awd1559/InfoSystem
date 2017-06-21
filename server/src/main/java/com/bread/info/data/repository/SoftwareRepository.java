package com.bread.info.data.repository;

import com.bread.info.data.model.Software;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SoftwareRepository extends CrudRepository<Software, UUID> {
}
