package com.amazonagency.restapi.model.data;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SalesAndTrafficByDate {
    @Id
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
