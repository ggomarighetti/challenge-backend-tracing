package com.ggomarighetti.tracing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ggomarighetti.tracing.dto.StatsResponseDto;
import com.ggomarighetti.tracing.entity.PetitionEntity;
import com.ggomarighetti.tracing.service.impl.StatsServiceImpl;
import com.ggomarighetti.tracing.service.impl.TracingServiceImpl;
import com.ggomarighetti.tracing.util.TestEntityCreator;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
public class StatsControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatsController statsController;

    @MockBean
    private StatsServiceImpl statsService;

    @Spy
    private final TestEntityCreator testEntityCreator = new TestEntityCreator();

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void getStats() throws Exception {

        List<PetitionEntity> petitionsList = List.of(testEntityCreator.examplePetitionEntity(),
                testEntityCreator.examplePetitionEntity(), testEntityCreator.examplePetitionEntity());

        StatsResponseDto statsResponseDto = StatsResponseDto.builder()
                .farthestDistance(petitionsList.stream().findFirst().orElseThrow().getDistance())
                .nearestDistance(petitionsList.get(petitionsList.size() - 1).getDistance())
                .averageDistance(petitionsList.stream().map(x -> x.getDistance()).reduce(0D, Double::sum) / petitionsList.size())
                .build();

        when(statsService.getStats()).thenReturn(statsResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/stats")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}