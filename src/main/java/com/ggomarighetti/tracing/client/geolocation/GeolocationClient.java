package com.ggomarighetti.tracing.client.geolocation;

import com.ggomarighetti.tracing.client.geolocation.domain.GeolocationResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "geolocation-client", url = "${geolocation.search.uri}")
public interface GeolocationClient {

    @Hidden
    @GetMapping("/{countryCode}?fields=name,languages,timezones,latlng,currencies")
    // Gets from an external api the details of a country with the parameter "countryCode", it only accepts its ISO code.
    public GeolocationResponse findbyCountryCode(@PathVariable String countryCode);
}
