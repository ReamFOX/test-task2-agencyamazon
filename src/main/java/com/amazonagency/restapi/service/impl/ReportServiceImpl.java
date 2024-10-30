package com.amazonagency.restapi.service.impl;

import com.amazonagency.restapi.dto.data.StatisticByAsin;
import com.amazonagency.restapi.dto.data.StatisticByDate;
import com.amazonagency.restapi.model.data.Report;
import com.amazonagency.restapi.model.data.SalesAndTrafficByAsin;
import com.amazonagency.restapi.model.data.SalesAndTrafficByDate;
import com.amazonagency.restapi.repository.ReportByAsinRepository;
import com.amazonagency.restapi.repository.ReportByDateRepository;
import com.amazonagency.restapi.service.ReportReader;
import com.amazonagency.restapi.service.ReportService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportReader reportReader;
    private final ReportByDateRepository reportByDateRepository;
    private final ReportByAsinRepository reportByAsinRepository;

    @Caching(evict = {
            @CacheEvict(value = "by_asins_cache", allEntries = true),
            @CacheEvict(value = "by_date_cache", allEntries = true),
            @CacheEvict(value = "total_cache", allEntries = true)
    })
    @Scheduled(cron = "0 0/15 * * * ?")
    @Override
    public void fetchAndSave() {
        Report report = reportReader.read();
        List<SalesAndTrafficByAsin> reportByAsin = report.getSalesAndTrafficByAsin();
        List<SalesAndTrafficByDate> reportByDate = report.getSalesAndTrafficByDate();

        reportByAsinRepository.saveAll(reportByAsin);
        reportByDateRepository.saveAll(reportByDate);
    }

    @Cacheable(value = "by_date_cache")
    @Override
    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate(LocalDate startDate,
                                                                LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date can't be before start date.");
        }
        return reportByDateRepository.getByDateBetween(startDate.minusDays(1), endDate.plusDays(1));
    }

    @Cacheable(value = "by_asins_cache")
    @Override
    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(List<String> asins) {
        return reportByAsinRepository.getByParentAsinIn(asins);
    }

    @Cacheable(value = "total_cache", key = "'total_by_date'")
    @Override
    public StatisticByDate getStatisticByDate() {
        var statisticByDate = new StatisticByDate();
        List<SalesAndTrafficByDate> allDays = reportByDateRepository.findAll();
        allDays.forEach(statisticByDate::add);
        statisticByDate.getTotalSales().calculateAverages();
        statisticByDate.getTotalTraffic().calculateAverages(allDays.size());
        return statisticByDate;
    }

    @Cacheable(value = "total_cache", key = "'total_by_asins'")
    @Override
    public StatisticByAsin getStatisticByAsin() {
        var statisticByAsin = new StatisticByAsin();
        List<SalesAndTrafficByAsin> allAsins = reportByAsinRepository.findAll();
        allAsins.forEach(statisticByAsin::add);
        statisticByAsin.getTotalTraffic().calculateAverages(allAsins.size());
        return statisticByAsin;
    }
}
