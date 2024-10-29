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
public class SalesByAsin extends AbstractSales {

    @Override
    public AbstractSales add(AbstractSales other) {
        if (!(other instanceof SalesByAsin otherSales)) {
            throw new IllegalArgumentException("Expected SalesByDate instance");
        }
        super.add(otherSales);
        return this;
    }
}
