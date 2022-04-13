package com.ggomarighetti.tracing.client.geolocation.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GeolocationResponseName {
    private String common;
    private String official;
    private Map<String, GeolocationResponseNativeName> nativeName;
}
