package com.amazonagency.restapi.model.data;

import static com.amazonagency.restapi.util.MathUtil.finalRound;

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

    @Override
    public TrafficByDate add(AbstractTraffic other) {
        if (!(other instanceof TrafficByDate otherTraffic)) {
            throw new IllegalArgumentException("Expected TrafficByDate instance");
        }
        super.add(other);
        this.buyBoxPercentage += otherTraffic.buyBoxPercentage;
        this.buyBoxPercentageB2B += otherTraffic.buyBoxPercentageB2B;
        this.orderItemSessionPercentage += otherTraffic.orderItemSessionPercentage;
        this.orderItemSessionPercentageB2B += otherTraffic.orderItemSessionPercentageB2B;
        this.unitSessionPercentage += otherTraffic.unitSessionPercentage;
        this.unitSessionPercentageB2B += otherTraffic.unitSessionPercentageB2B;
        this.averageOfferCount += otherTraffic.averageOfferCount;
        this.averageParentItems += otherTraffic.averageParentItems;
        this.feedbackReceived += otherTraffic.feedbackReceived;
        this.negativeFeedbackReceived += otherTraffic.negativeFeedbackReceived;
        this.receivedNegativeFeedbackRate += otherTraffic.receivedNegativeFeedbackRate;

        return this;
    }

    public void calculateAverages(int totalDays) {
        if (totalDays > 0) {
            this.buyBoxPercentage = finalRound(this.buyBoxPercentage / totalDays);
            this.buyBoxPercentageB2B = finalRound(this.buyBoxPercentageB2B / totalDays);
            this.orderItemSessionPercentage = finalRound(this.orderItemSessionPercentage / totalDays);
            this.orderItemSessionPercentageB2B = finalRound(this.orderItemSessionPercentageB2B / totalDays);
            this.unitSessionPercentage = finalRound(this.unitSessionPercentage / totalDays);
            this.unitSessionPercentageB2B = finalRound(this.unitSessionPercentageB2B / totalDays);
            this.averageOfferCount /= totalDays;
            this.averageParentItems /= totalDays;
        } else {
            this.buyBoxPercentage = 0.0;
            this.buyBoxPercentageB2B = 0.0;
            this.orderItemSessionPercentage = 0.0;
            this.orderItemSessionPercentageB2B = 0.0;
            this.unitSessionPercentage = 0.0;
            this.unitSessionPercentageB2B = 0.0;
            this.averageOfferCount = 0;
            this.averageParentItems = 0;
        }

        if (this.feedbackReceived > 0) {
            this.receivedNegativeFeedbackRate =
                    finalRound((double) this.negativeFeedbackReceived / this.feedbackReceived);
        } else {
            this.receivedNegativeFeedbackRate = 0.0;
        }
    }
}
