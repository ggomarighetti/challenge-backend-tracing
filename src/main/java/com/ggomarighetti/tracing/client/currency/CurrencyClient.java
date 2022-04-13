package com.ggomarighetti.tracing.client.currency;

import com.ggomarighetti.tracing.client.currency.domain.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@FeignClient(name = "currency-client", url = "${currency.search.uri}")
public interface CurrencyClient {

    @GetMapping("?from={fromCurrency}&to={toCurrency}")
    public CurrencyResponse convert(@PathVariable String fromCurrency, @PathVariable String toCurrency);
}
