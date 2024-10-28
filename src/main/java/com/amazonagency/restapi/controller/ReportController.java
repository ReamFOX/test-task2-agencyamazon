package com.amazonagency.restapi.controller;

import com.amazonagency.restapi.model.data.SalesAndTrafficByAsin;
import com.amazonagency.restapi.model.data.SalesAndTrafficByDate;
import com.amazonagency.restapi.model.data.StatisticByAsin;
import com.amazonagency.restapi.model.data.StatisticByDate;
import com.amazonagency.restapi.service.ReportService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/by_asins")
    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsins(@RequestParam List<String> asins) {
        return reportService.getSalesAndTrafficByAsin(asins);
    }

    @GetMapping("/by_asins")
    public StatisticByAsin getTotalStatisticByAsins() {
        return reportService.getStatisticByAsin();
    }

    @GetMapping("/by_date")
    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate(@RequestParam LocalDate startDate,
                                                                @RequestParam LocalDate endDate) {
        return reportService.getSalesAndTrafficByDate(startDate, endDate);
    }

    @GetMapping("/by_date")
    public StatisticByDate getStatisticByDate() {
        return reportService.getStatisticByDate();
    }
}
