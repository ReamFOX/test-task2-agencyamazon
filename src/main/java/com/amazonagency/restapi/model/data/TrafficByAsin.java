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

    @Override
    public TrafficByAsin add(AbstractTraffic other) {
        if (!(other instanceof TrafficByAsin otherTraffic)) {
            throw new IllegalArgumentException("Expected TrafficByAsin instance");
        }
        super.add(other);

        this.browserSessionPercentage += otherTraffic.browserSessionPercentage;
        this.browserSessionPercentageB2B += otherTraffic.browserSessionPercentageB2B;
        this.mobileAppSessionPercentage += otherTraffic.mobileAppSessionPercentage;
        this.mobileAppSessionPercentageB2B += otherTraffic.mobileAppSessionPercentageB2B;
        this.sessionPercentage += otherTraffic.sessionPercentage;
        this.sessionPercentageB2B += otherTraffic.sessionPercentageB2B;
        this.browserPageViewsPercentage += otherTraffic.browserPageViewsPercentage;
        this.browserPageViewsPercentageB2B += otherTraffic.browserPageViewsPercentageB2B;
        this.mobileAppPageViewsPercentage += otherTraffic.mobileAppPageViewsPercentage;
        this.mobileAppPageViewsPercentageB2B += otherTraffic.mobileAppPageViewsPercentageB2B;
        this.pageViewsPercentage += otherTraffic.pageViewsPercentage;
        this.pageViewsPercentageB2B += otherTraffic.pageViewsPercentageB2B;
        this.buyBoxPercentage += otherTraffic.buyBoxPercentage;
        this.buyBoxPercentageB2B += otherTraffic.buyBoxPercentageB2B;
        this.unitSessionPercentage += otherTraffic.unitSessionPercentage;
        this.unitSessionPercentageB2B += otherTraffic.unitSessionPercentageB2B;

        return this;
    }

    public void calculateAverages(int totalAsins) {
        if (totalAsins > 0) {
            this.browserSessionPercentage = finalRound(this.browserSessionPercentage / totalAsins);
            this.browserSessionPercentageB2B = finalRound(this.browserSessionPercentageB2B / totalAsins);
            this.mobileAppSessionPercentage = finalRound(this.mobileAppSessionPercentage / totalAsins);
            this.mobileAppSessionPercentageB2B = finalRound(this.mobileAppSessionPercentageB2B / totalAsins);
            this.sessionPercentage = finalRound(this.sessionPercentage / totalAsins);
            this.sessionPercentageB2B = finalRound(this.sessionPercentageB2B / totalAsins);
            this.browserPageViewsPercentage = finalRound(this.browserPageViewsPercentage / totalAsins);
            this.browserPageViewsPercentageB2B = finalRound(this.browserPageViewsPercentageB2B / totalAsins);
            this.mobileAppPageViewsPercentage = finalRound(this.mobileAppPageViewsPercentage / totalAsins);
            this.mobileAppPageViewsPercentageB2B = finalRound(this.mobileAppPageViewsPercentageB2B / totalAsins);
            this.pageViewsPercentage = finalRound(this.pageViewsPercentage / totalAsins);
            this.pageViewsPercentageB2B = finalRound(this.pageViewsPercentageB2B / totalAsins);
            this.buyBoxPercentage = finalRound(this.buyBoxPercentage / totalAsins);
            this.buyBoxPercentageB2B = finalRound(this.buyBoxPercentageB2B / totalAsins);
            this.unitSessionPercentage = finalRound(this.unitSessionPercentage / totalAsins);
            this.unitSessionPercentageB2B = finalRound(this.unitSessionPercentageB2B / totalAsins);
        } else {
            this.browserSessionPercentage = 0.0;
            this.browserSessionPercentageB2B = 0.0;
            this.mobileAppSessionPercentage = 0.0;
            this.mobileAppSessionPercentageB2B = 0.0;
            this.sessionPercentage = 0.0;
            this.sessionPercentageB2B = 0.0;
            this.browserPageViewsPercentage = 0.0;
            this.browserPageViewsPercentageB2B = 0.0;
            this.mobileAppPageViewsPercentage = 0.0;
            this.mobileAppPageViewsPercentageB2B = 0.0;
            this.pageViewsPercentage = 0.0;
            this.pageViewsPercentageB2B = 0.0;
            this.buyBoxPercentage = 0.0;
            this.buyBoxPercentageB2B = 0.0;
            this.unitSessionPercentage = 0.0;
            this.unitSessionPercentageB2B = 0.0;
        }
    }
}
