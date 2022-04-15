package com.ggomarighetti.tracing.util;

import com.ggomarighetti.tracing.entity.CountryEntity;
import com.ggomarighetti.tracing.entity.PetitionEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class TestEntityCreator {

    public CountryEntity exampleCountryEntity() {
        return CountryEntity.builder()
                .id("123e4567-e89b-12d3-a456-556642440000")
                .name("Argentina")
                .code("AR")
                .languages(Arrays.stream((new String[]{"Spanish"})).collect(Collectors.toList()))
                .timezones(Arrays.stream((new String[]{"UTC-03:00"})).collect(Collectors.toList()))
                .latitude(-26.18D)      //Coordinates changed to test distance calculations.
                .longitude(-58.17D)     //If the real ones are used, it will always give 0.0.
                .currency(Arrays.stream((new String[]{"ARS"})).collect(Collectors.toList()))
                .build();
    }

    public PetitionEntity examplePetitionEntity() {
        return PetitionEntity.builder()
                .id("123e4567-e89b-12d3-a456-556642440000")
                .distance(Double.valueOf(new Random().nextInt(4000)))
                .build();
    }


}
