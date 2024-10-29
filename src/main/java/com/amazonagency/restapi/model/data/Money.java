package com.amazonagency.restapi.model.data;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Money implements Serializable {
    private BigDecimal amount;
    private String currencyCode;

    public Money add(Money other) {
        this.amount = this.amount.add(other.amount);
        return this;
    }
}
