package com.ggomarighetti.tracing.service.impl;

import com.ggomarighetti.tracing.dto.StatsResponseDto;
import com.ggomarighetti.tracing.entity.PetitionEntity;
import com.ggomarighetti.tracing.repository.PetitionRepository;
import com.ggomarighetti.tracing.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private PetitionRepository petitionRepository;

    @Override
    public StatsResponseDto getStats() {

        List<PetitionEntity> petitionsList = petitionRepository.findAll(Sort.by(Sort.Order.desc("distance")));

        StatsResponseDto statsResponseDto = StatsResponseDto.builder()
                .farthestDistance(petitionsList.stream().findFirst().orElseThrow().getDistance())
                .nearestDistance(petitionsList.get(petitionsList.size()-1).getDistance())
                .averageDistance(petitionsList.stream().map(x -> x.getDistance()).reduce(0D, Double::sum) / petitionsList.size())
                .build();

        return statsResponseDto;
    }
}
