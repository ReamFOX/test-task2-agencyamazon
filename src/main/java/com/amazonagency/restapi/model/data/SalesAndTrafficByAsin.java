package com.amazonagency.restapi.model.data;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SalesAndTrafficByAsin {
    @Id
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
