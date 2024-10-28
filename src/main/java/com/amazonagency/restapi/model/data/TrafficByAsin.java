package com.amazonagency.restapi.model.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class TrafficByAsin extends AbstractTraffic {
    protected double browserSessionPercentage;
    protected double browserSessionPercentageB2B;
    protected double mobileAppSessionPercentage;
    protected double mobileAppSessionPercentageB2B;
    protected double sessionPercentage;
    protected double sessionPercentageB2B;
    protected double browserPageViewsPercentage;
    protected double browserPageViewsPercentageB2B;
    protected double mobileAppPageViewsPercentage;
    protected double mobileAppPageViewsPercentageB2B;
    protected double pageViewsPercentage;
    protected double pageViewsPercentageB2B;
    protected double buyBoxPercentage;
    protected double buyBoxPercentageB2B;
    protected double unitSessionPercentage;
    protected double unitSessionPercentageB2B;
}
