package com.amazonagency.restapi.model.data;

public class StatisticByAsin {
    private SalesByAsin totalSales;
    private TrafficByAsin totalTraffic;

    public void add(SalesAndTrafficByAsin other) {
        if (totalSales == null) {
            totalSales = other.getSalesByAsin();
        } else {
            totalSales.add(other.getSalesByAsin());
        }
        if (totalTraffic == null) {
            totalTraffic = other.getTrafficByAsin();
        } else {
            totalTraffic.add(other.getTrafficByAsin());
        }
    }
}
