package com.amazonagency.restapi.model.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TrafficByAsin extends AbstractTraffic {
    private double browserSessionPercentage;
    private double browserSessionPercentageB2B;
    private double mobileAppSessionPercentage;
    private double mobileAppSessionPercentageB2B;
    private double sessionPercentage;
    private double sessionPercentageB2B;
    private double browserPageViewsPercentage;
    private double browserPageViewsPercentageB2B;
    private double mobileAppPageViewsPercentage;
    private double mobileAppPageViewsPercentageB2B;
    private double pageViewsPercentage;
    private double pageViewsPercentageB2B;
    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private double unitSessionPercentage;
    private double unitSessionPercentageB2B;
}
