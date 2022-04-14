package com.ggomarighetti.tracing.client.tracing;

import com.ggomarighetti.tracing.client.tracing.domain.TracingResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@FeignClient(name = "tracing-client", url = "${tracing.search.uri}")
public interface TracingClient {

    @Hidden
    @GetMapping("/{ipAddress}?fields=countryCode")
    // Obtains from an external api the ISO code of the country to which an IP address corresponds through the "ipAddress" parameter. only works with IPv4.
    public TracingResponse findByIpAddress(@PathVariable String ipAddress);
}
