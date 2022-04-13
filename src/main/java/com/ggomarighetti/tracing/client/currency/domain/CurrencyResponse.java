package com.ggomarighetti.tracing.client.currency.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class CurrencyResponse {
    public Map<String, BigDecimal> info;
}
