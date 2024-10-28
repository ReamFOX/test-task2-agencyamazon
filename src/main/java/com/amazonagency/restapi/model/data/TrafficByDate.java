package com.amazonagency.restapi.model.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TrafficByDate extends AbstractTraffic {
    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private double orderItemSessionPercentage;
    private double orderItemSessionPercentageB2B;
    private double unitSessionPercentage;
    private double unitSessionPercentageB2B;
    private int averageOfferCount;
    private int averageParentItems;
    private int feedbackReceived;
    private int negativeFeedbackReceived;
    private double receivedNegativeFeedbackRate;
}
