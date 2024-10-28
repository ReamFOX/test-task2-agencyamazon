package com.amazonagency.restapi.model.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
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
}
