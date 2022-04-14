package com.ggomarighetti.tracing.client.currency;

import com.ggomarighetti.tracing.client.currency.domain.CurrencyResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@FeignClient(name = "currency-client", url = "${currency.search.uri}")
public interface CurrencyClient {

    @Hidden
    @GetMapping("?from={fromCurrency}&to={toCurrency}")
    // It obtains from an external api the price of two currencies indicated with the parameters "fromCurrency" and "toCurrency", it only accepts their ISO codes.
    public CurrencyResponse convert(@PathVariable String fromCurrency, @PathVariable String toCurrency);
}
