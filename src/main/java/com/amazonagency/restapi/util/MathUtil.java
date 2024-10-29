package com.amazonagency.restapi.util;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

public class MathUtil {

    public static final int SCALE = 2;

    public static BigDecimal finalRound(BigDecimal value) {
        return value.setScale(SCALE, HALF_UP);
    }

    public static Double finalRound(Double value) {
        return new BigDecimal(value).setScale(SCALE, HALF_UP).doubleValue();
    }
}
