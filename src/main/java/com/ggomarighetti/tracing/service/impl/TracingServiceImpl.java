package com.ggomarighetti.tracing.service.impl;

import com.ggomarighetti.tracing.client.geolocation.GeolocationClient;
import com.ggomarighetti.tracing.client.geolocation.domain.GeolocationResponse;
import com.ggomarighetti.tracing.client.tracing.TracingClient;
import com.ggomarighetti.tracing.client.tracing.domain.TracingResponse;
import com.ggomarighetti.tracing.dto.TracingResponseDto;
import com.ggomarighetti.tracing.entity.CountryEntity;
import com.ggomarighetti.tracing.entity.PetitionEntity;
import com.ggomarighetti.tracing.mapper.CountryMapper;
import com.ggomarighetti.tracing.mapper.CurrencyMapper;
import com.ggomarighetti.tracing.mapper.TimezoneMapper;
import com.ggomarighetti.tracing.repository.CountryRepository;
import com.ggomarighetti.tracing.repository.PetitionRepository;
import com.ggomarighetti.tracing.service.TracingService;
import com.ggomarighetti.tracing.util.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TracingServiceImpl implements TracingService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private PetitionRepository petitionRepository;

    @Autowired
    private TracingClient tracingClient;

    @Autowired
    private GeolocationClient geolocationClient;

    @Autowired
    private DistanceUtil distanceUtil;

    @Autowired
    private TimezoneMapper timezoneMapper;

    @Autowired
    private CurrencyMapper currencyMapper;

    @Override
    // Method to call the external apis and from the ip address to obtain the ISO code of the country to which it
    // corresponds and then get all the details, utilities are used to calculate the current time in each time zone
    // and the current exchange rate of the currency against the U.S. dollar.
    public TracingResponseDto traceIpAddress(String ipAddress) {

        TracingResponse tracingResponse = tracingClient.findByIpAddress(ipAddress);

        CountryEntity countryEntity = countryRepository.findByName(tracingResponse.getCountryCode()).orElse(null);

        // If the country is not registered in the database by its ISO code, we get it from the external api rest.
        if (countryEntity == null) {

            GeolocationResponse geolocationResponse = geolocationClient.findbyCountryCode(tracingResponse.getCountryCode());
            countryEntity = countryMapper.geolocationResponseToCountryEntity(geolocationResponse);
            countryEntity = countryRepository.save(countryEntity);
        }

        TracingResponseDto tracingResponseDto = TracingResponseDto.builder()
                .countryName(countryEntity.getName())
                .countryCode(tracingResponse.getCountryCode())
                .timezones(timezoneMapper.timezonesListToTimezonesMap(countryEntity.getTimezones()))
                .distance(distanceUtil.distanceBetween(countryEntity.getLatitude(), countryEntity.getLongitude(), -34.0, -64.0))
                .currencies(currencyMapper.currencyListToCurrencyMap(countryEntity.getCurrency()))
                .build();

        PetitionEntity petitionEntity = PetitionEntity.builder()
                .distance(tracingResponseDto.getDistance())
                .country(CountryEntity.builder().id(countryEntity.getId()).build())
                .build();

        petitionRepository.save(petitionEntity);

        return tracingResponseDto;
    }
}
