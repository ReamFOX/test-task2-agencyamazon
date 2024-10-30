package com.amazonagency.restapi.service;

import com.amazonagency.restapi.dto.data.StatisticByAsin;
import com.amazonagency.restapi.dto.data.StatisticByDate;
import com.amazonagency.restapi.model.data.SalesAndTrafficByAsin;
import com.amazonagency.restapi.model.data.SalesAndTrafficByDate;
import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    void fetchAndSave();

    List<SalesAndTrafficByDate> getSalesAndTrafficByDate(LocalDate startDate, LocalDate endDate);

    List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(List<String> asins);

    StatisticByDate getStatisticByDate();

    StatisticByAsin getStatisticByAsin();
}
