package com.amazonagency.restapi.model.data;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("sales_and_traffic_by_date")
public class SalesAndTrafficByDate implements Serializable {
    @Id
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
