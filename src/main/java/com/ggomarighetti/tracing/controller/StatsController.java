package com.ggomarighetti.tracing.controller;

import com.ggomarighetti.tracing.dto.StatsResponseDto;
import com.ggomarighetti.tracing.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public StatsResponseDto getStats() {
        return statsService.getStats();
    }

}
