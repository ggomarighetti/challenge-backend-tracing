package com.ggomarighetti.tracing.util;

import org.springframework.stereotype.Component;

@Component
public class DistanceUtil {

    private static final double earthRadius = 6371.01;

    public double distanceBetween(double latitudeA, double longitudeA, double latitudeB, double longitudeB) {
        latitudeA = Math.toRadians(latitudeA);
        longitudeA = Math.toRadians(longitudeA);
        latitudeB = Math.toRadians(latitudeB);
        longitudeB = Math.toRadians(longitudeB);

        return earthRadius * Math.acos(Math.sin(latitudeA) * Math.sin(latitudeB) + Math.cos(latitudeA) * Math.cos(latitudeB) * Math.cos(longitudeA - longitudeB));
    }
}
