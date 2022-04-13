package com.ggomarighetti.tracing.client.geolocation.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GeolocationResponse {
    private GeolocationResponseName name;
    private Map<String, GeolocationResponseCurrency> currencies;
    private Map<String, String> languages;
    private List<Double> latlng;
    private List<String> timezones;
}
