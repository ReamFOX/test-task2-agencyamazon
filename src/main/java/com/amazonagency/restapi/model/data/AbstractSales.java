package com.amazonagency.restapi.model.data;

import java.io.Serializable;
import java.math.MathContext;
import lombok.Data;

@Data
public abstract class AbstractSales implements Serializable {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private Money orderedProductSales;
    private Money orderedProductSalesB2B;

    public AbstractSales add(AbstractSales other) {
        this.orderedProductSales.setAmount(
                this.orderedProductSales.getAmount().add(other.orderedProductSales.getAmount())
        );
        this.orderedProductSalesB2B.setAmount(
                this.orderedProductSalesB2B.getAmount().add(other.orderedProductSalesB2B.getAmount()
                        .round(MathContext.DECIMAL128)));
        this.totalOrderItems += other.totalOrderItems;
        this.totalOrderItemsB2B += other.totalOrderItemsB2B;
        this.unitsOrdered += other.unitsOrdered;
        this.unitsOrderedB2B += other.unitsOrderedB2B;

        return this;
    }
}
