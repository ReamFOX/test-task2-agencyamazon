package com.amazonagency.restapi.model.data;

import lombok.Data;

@Data
public abstract class AbstractSales {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private Money orderedProductSales;
    private Money orderedProductSalesB2B;
}
