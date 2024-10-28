package com.amazonagency.restapi.model.data;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SalesAndTrafficByAsin implements Serializable {
    @Id
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
