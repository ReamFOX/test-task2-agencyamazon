package com.amazonagency.restapi.model.data;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("sales_and_traffic_by_asin")
public class SalesAndTrafficByAsin implements Serializable {
    @Id
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
