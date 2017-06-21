package com.bread.info.data.repository;

import com.bread.info.data.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CompanyRepository extends CrudRepository<Company, UUID> {
}
