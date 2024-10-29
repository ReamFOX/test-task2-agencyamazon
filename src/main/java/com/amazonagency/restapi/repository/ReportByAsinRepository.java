package com.amazonagency.restapi.repository;

import com.amazonagency.restapi.model.data.SalesAndTrafficByAsin;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportByAsinRepository extends MongoRepository<SalesAndTrafficByAsin, String> {
    List<SalesAndTrafficByAsin> getByParentAsinIn(List<String> asins);
}
