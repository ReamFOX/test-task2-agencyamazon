package com.amazonagency.restapi.model.data;

import lombok.Data;

@Data
public class SalesAndTrafficByAsin {
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
