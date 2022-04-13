package com.ggomarighetti.tracing.mapper;

import com.ggomarighetti.tracing.client.geolocation.domain.GeolocationResponse;
import com.ggomarighetti.tracing.entity.CountryEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CountryMapper {

    public CountryEntity geolocationResponseToCountryEntity(GeolocationResponse geolocationResponse){
        return CountryEntity.builder()
                .name(geolocationResponse.getName().getCommon())
                .languages(geolocationResponse.getLanguages().values().stream().collect(Collectors.toList()))
                .timezones(geolocationResponse.getTimezones())
                .latitude(geolocationResponse.getLatlng().get(0))
                .longitude(geolocationResponse.getLatlng().get(1))
                .currency(geolocationResponse.getCurrencies().keySet().stream().collect(Collectors.toList()))
                .build();
    }
}
