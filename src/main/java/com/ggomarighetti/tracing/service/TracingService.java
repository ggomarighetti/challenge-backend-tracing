package com.ggomarighetti.tracing.service;


import com.ggomarighetti.tracing.dto.TracingResponseDto;
import com.ggomarighetti.tracing.entity.CountryEntity;

public interface TracingService {

    TracingResponseDto traceIpAddress(String ipAddress);
}
