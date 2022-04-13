package com.ggomarighetti.tracing.client.tracing;

import com.ggomarighetti.tracing.client.tracing.domain.TracingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@FeignClient(name = "tracing-client", url = "${tracing.search.uri}")
public interface TracingClient {

    @GetMapping("/{ipAddress}?fields=countryCode")
    public TracingResponse findByIpAddress(@PathVariable String ipAddress);
}
