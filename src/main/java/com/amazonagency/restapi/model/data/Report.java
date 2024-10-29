package com.amazonagency.restapi.model.data;

import java.util.List;
import lombok.Data;

@Data
public class Report {
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
