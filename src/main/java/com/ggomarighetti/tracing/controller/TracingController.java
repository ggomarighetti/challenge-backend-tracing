package com.ggomarighetti.tracing.controller;

import com.ggomarighetti.tracing.dto.TracingResponseDto;
import com.ggomarighetti.tracing.entity.CountryEntity;
import com.ggomarighetti.tracing.service.TracingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TracingController {

    @Autowired
    private TracingService tracingService;

    @GetMapping("/{ipAddress}")
    public TracingResponseDto traceIpAddress(@PathVariable String ipAddress) {
        return tracingService.traceIpAddress(ipAddress);
    }
}
