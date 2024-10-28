package com.amazonagency.restapi.model.data;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SalesAndTrafficByDate implements Serializable {
    @Id
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
