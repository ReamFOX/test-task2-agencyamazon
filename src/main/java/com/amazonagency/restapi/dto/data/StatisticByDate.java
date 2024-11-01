package com.amazonagency.restapi.dto.data;

import com.amazonagency.restapi.model.data.SalesAndTrafficByDate;
import com.amazonagency.restapi.model.data.SalesByDate;
import com.amazonagency.restapi.model.data.TrafficByDate;
import java.io.Serializable;
import lombok.Data;

@Data
public class StatisticByDate implements Serializable {
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
