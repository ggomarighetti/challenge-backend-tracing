package com.ggomarighetti.tracing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ggomarighetti.tracing.dto.TracingResponseDto;
import com.ggomarighetti.tracing.entity.CountryEntity;
import com.ggomarighetti.tracing.mapper.CurrencyMapper;
import com.ggomarighetti.tracing.mapper.TimezoneMapper;
import com.ggomarighetti.tracing.service.impl.TracingServiceImpl;
import com.ggomarighetti.tracing.util.DistanceUtil;
import com.ggomarighetti.tracing.util.TestEntityCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
public class TracingControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TracingServiceImpl tracingService;

    @InjectMocks
    private TracingController tracingController;

    @Spy
    private final TimezoneMapper timezoneMapper = new TimezoneMapper();

    @Spy
    private final DistanceUtil distanceUtil = new DistanceUtil();

    @Spy
    private final TestEntityCreator testEntityCreator = new TestEntityCreator();

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void traceIpAddress() throws Exception {

        CountryEntity countryEntity = testEntityCreator.exampleCountryEntity();

        TracingResponseDto tracingResponseDto = TracingResponseDto.builder()
                .ipAddress("1.178.48.0")
                .countryName(countryEntity.getName())
                .countryCode(countryEntity.getCode())
                .timezones(timezoneMapper.timezonesListToTimezonesMap(countryEntity.getTimezones()))
                .distance(distanceUtil.distanceBetween(countryEntity.getLatitude(), countryEntity.getLongitude(), -34.0, -64.0))
                .currencies(Map.of("ARS", BigDecimal.valueOf(195)))
                .build();

        when(tracingService.traceIpAddress("1.178.48.0")).thenReturn(tracingResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/1.178.48.0")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}