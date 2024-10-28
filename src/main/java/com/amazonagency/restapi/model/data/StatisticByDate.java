package com.amazonagency.restapi.model.data;

public class StatisticByDate {
    private SalesByDate totalSales;
    private TrafficByDate totalTraffic;

    public void add(SalesAndTrafficByDate other) {
        if (totalSales == null) {
            totalSales = other.getSalesByDate();
        } else {
            totalSales.add(other.getSalesByDate());
        }
        if (totalTraffic == null) {
            totalTraffic = other.getTrafficByDate();
        } else {
            totalTraffic.add(other.getTrafficByDate());
        }
    }
}
