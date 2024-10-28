package com.amazonagency.restapi.service.impl;

import com.amazonagency.restapi.model.data.Report;
import com.amazonagency.restapi.model.data.SalesAndTrafficByAsin;
import com.amazonagency.restapi.model.data.SalesAndTrafficByDate;
import com.amazonagency.restapi.model.data.StatisticByAsin;
import com.amazonagency.restapi.model.data.StatisticByDate;
import com.amazonagency.restapi.repository.ReportByAsinRepository;
import com.amazonagency.restapi.repository.ReportByDateRepository;
import com.amazonagency.restapi.repository.ReportSpecificationRepository;
import com.amazonagency.restapi.service.ReportReader;
import com.amazonagency.restapi.service.ReportService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportReader reportReader;
    private final ReportByDateRepository reportByDateRepository;
    private final ReportByAsinRepository reportByAsinRepository;
    private final ReportSpecificationRepository reportSpecificationRepository;

    @Override
    public void fetchAndSave() {
        Report report = reportReader.read();
        var reportSpecification = report.getReportSpecification();
        List<SalesAndTrafficByAsin> reportByAsin = report.getSalesAndTrafficByAsin();
        List<SalesAndTrafficByDate> reportByDate = report.getSalesAndTrafficByDate();

        reportSpecificationRepository.save(reportSpecification);
        reportByAsinRepository.saveAll(reportByAsin);
        reportByDateRepository.saveAll(reportByDate);
    }

    @Override
    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate(LocalDate startDate,
                                                                LocalDate endDate) {
        return reportByDateRepository.getByDateBetween(startDate, endDate);
    }

    @Override
    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(List<String> asins) {
        return reportByAsinRepository.getByAsinIn(asins);
    }

    @Override
    public StatisticByDate getStatisticByDate() {
        var statisticByDate = new StatisticByDate();
        reportByDateRepository.findAll().forEach(statisticByDate::add);
        return statisticByDate;
    }

    @Override
    public StatisticByAsin getStatisticByAsin() {
        var statisticByAsin = new StatisticByAsin();
        reportByAsinRepository.findAll().forEach(statisticByAsin::add);
        return statisticByAsin;
    }
}
