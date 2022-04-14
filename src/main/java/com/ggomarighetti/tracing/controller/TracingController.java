package com.ggomarighetti.tracing.controller;

import com.ggomarighetti.tracing.dto.TracingResponseDto;
import com.ggomarighetti.tracing.entity.CountryEntity;
import com.ggomarighetti.tracing.service.TracingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TracingController {

    @Autowired
    private TracingService tracingService;

    @GetMapping(value = "/{ipAddress}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Trace the data of an ip address")
    @ApiResponse(responseCode = "200")
    public TracingResponseDto traceIpAddress(@PathVariable String ipAddress) {
        return tracingService.traceIpAddress(ipAddress);
    }
}
