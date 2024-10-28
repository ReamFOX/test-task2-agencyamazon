package com.amazonagency.restapi.repository;

import com.amazonagency.restapi.model.data.SalesAndTrafficByDate;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportByDateRepository extends MongoRepository<SalesAndTrafficByDate, LocalDate> {
    List<SalesAndTrafficByDate> getByDateBetween(LocalDate startDate, LocalDate endDate);
}
