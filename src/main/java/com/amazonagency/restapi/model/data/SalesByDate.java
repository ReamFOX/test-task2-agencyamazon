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
public class SalesByDate extends AbstractSales {
    protected Money averageSalesPerOrderItem;
    protected Money averageSalesPerOrderItemB2B;
    protected double averageUnitsPerOrderItem;
    protected double averageUnitsPerOrderItemB2B;
    protected Money averageSellingPrice;
    protected Money averageSellingPriceB2B;
    protected int unitsRefunded;
    protected double refundRate;
    protected int claimsGranted;
    protected Money claimsAmount;
    protected Money shippedProductSales;
    protected int unitsShipped;
    protected int ordersShipped;
}
