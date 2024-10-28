package com.amazonagency.restapi.model.data;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Money {
    private BigDecimal amount;
    private String currencyCode;
}
