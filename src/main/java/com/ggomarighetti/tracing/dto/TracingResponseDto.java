package com.ggomarighetti.tracing.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TracingResponseDto {
    private String ipAddress;
    private String countryName;
    private String countryCode;
    private Map<String, String> timezones;
    private Double distance;
    private Map<String, BigDecimal> currencies;
}
