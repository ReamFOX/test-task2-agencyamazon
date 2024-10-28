package com.amazonagency.restapi.repository;

import com.amazonagency.restapi.model.data.ReportSpecification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportSpecificationRepository
        extends MongoRepository<ReportSpecification, String> {
}
