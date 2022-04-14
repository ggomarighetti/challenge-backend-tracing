package com.ggomarighetti.tracing.controller;

import com.ggomarighetti.tracing.dto.StatsResponseDto;
import com.ggomarighetti.tracing.service.StatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Gets the stadistics of ip address tracing")
    @ApiResponse(responseCode = "200")

    public StatsResponseDto getStats() {
        return statsService.getStats();
    }

}
