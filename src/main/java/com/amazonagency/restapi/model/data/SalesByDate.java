package com.amazonagency.restapi.model.data;

import com.amazonagency.restapi.util.MathUtil;
import java.math.BigDecimal;
import java.math.MathContext;
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
public class SalesByDate extends AbstractSales {
    private Money averageSalesPerOrderItem;
    private Money averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private Money averageSellingPrice;
    private Money averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private Money claimsAmount;
    private Money shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;

    @Override
    public SalesByDate add(AbstractSales other) {
        if (!(other instanceof SalesByDate otherSales)) {
            throw new IllegalArgumentException("Expected SalesByDate instance");
        }
        super.add(other);
        this.unitsShipped += otherSales.unitsShipped;
        this.ordersShipped += otherSales.ordersShipped;
        this.unitsRefunded += otherSales.unitsRefunded;
        this.claimsGranted += otherSales.claimsGranted;
        this.claimsAmount = this.claimsAmount.add(otherSales.claimsAmount);
        this.shippedProductSales = this.shippedProductSales.add(otherSales.shippedProductSales);

        return this;
    }

    public void calculateAverages() {
        if (this.getTotalOrderItems() > 0) {
            this.averageSalesPerOrderItem = new Money(
                    MathUtil.finalRound(this.getOrderedProductSales().getAmount()
                            .divide(BigDecimal.valueOf(this.getTotalOrderItems()), MathContext.DECIMAL128)),
                    this.getOrderedProductSales().getCurrencyCode()
            );
        } else {
            this.averageSalesPerOrderItem = new Money(BigDecimal.ZERO, "USD");
        }

        this.averageUnitsPerOrderItem = (this.getTotalOrderItems() > 0)
                ? MathUtil.finalRound((double) this.getUnitsOrdered() / this.getTotalOrderItems())
                : 0.0;

        if (this.getUnitsOrdered() > 0) {
            this.averageSellingPrice = new Money(
                    MathUtil.finalRound(this.getOrderedProductSales().getAmount()
                            .divide(BigDecimal.valueOf(this.getUnitsOrdered()), MathContext.DECIMAL128)),
                    this.getOrderedProductSales().getCurrencyCode()
            );
        } else {
            this.averageSellingPrice = new Money(BigDecimal.ZERO, "USD");
        }

        if (this.getTotalOrderItemsB2B() > 0) {
            this.averageSalesPerOrderItemB2B = new Money(
                    MathUtil.finalRound(this.getOrderedProductSalesB2B().getAmount()
                            .divide(BigDecimal.valueOf(this.getTotalOrderItemsB2B()), MathContext.DECIMAL128)),
                    this.getOrderedProductSalesB2B().getCurrencyCode()
            );
        } else {
            this.averageSalesPerOrderItemB2B = new Money(BigDecimal.ZERO, "USD");
        }

        this.averageUnitsPerOrderItemB2B = (this.getTotalOrderItemsB2B() > 0)
                ? MathUtil.finalRound((double) this.getUnitsOrderedB2B() / this.getTotalOrderItemsB2B())
                : 0.0;

        if (this.getUnitsOrderedB2B() > 0) {
            this.averageSellingPriceB2B = new Money(
                    MathUtil.finalRound(this.getOrderedProductSalesB2B().getAmount()
                            .divide(BigDecimal.valueOf(this.getUnitsOrderedB2B()), MathContext.DECIMAL128)),
                    this.getOrderedProductSalesB2B().getCurrencyCode()
            );
        } else {
            this.averageSellingPriceB2B = new Money(BigDecimal.ZERO, "USD");
        }

        this.refundRate = (this.getUnitsOrdered() > 0)
                ? MathUtil.finalRound((double) this.unitsRefunded / this.getUnitsOrdered() * 100)
                : 0.0;
    }
}
