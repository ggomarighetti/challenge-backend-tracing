package com.ggomarighetti.tracing.mapper;

import com.ggomarighetti.tracing.client.currency.CurrencyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyMapper {

    @Autowired
    private CurrencyClient currencyClient;

    // Help method to obtain the price and code of each currency and group them in a map.
    public Map<String, BigDecimal> currencyListToCurrencyMap(List<String> currencyList) {
        Map<String, BigDecimal> currencyMap = new HashMap<>();

        for (String currency : currencyList) {
            currencyMap.put(currency, currencyClient.convert("USD", currency).getInfo().values().stream().findFirst().orElse(null));
        }

        return currencyMap;
    }
}
