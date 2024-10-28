package com.amazonagency.restapi.model.data;

import lombok.Data;
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
public class TrafficByDate extends AbstractTraffic {
    protected double buyBoxPercentage;
    protected double buyBoxPercentageB2B;
    protected double orderItemSessionPercentage;
    protected double orderItemSessionPercentageB2B;
    protected double unitSessionPercentage;
    protected double unitSessionPercentageB2B;
    protected int averageOfferCount;
    protected int averageParentItems;
    protected int feedbackReceived;
    protected int negativeFeedbackReceived;
    protected double receivedNegativeFeedbackRate;
}
