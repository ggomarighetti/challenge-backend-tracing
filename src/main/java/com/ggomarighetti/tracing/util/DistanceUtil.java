package com.ggomarighetti.tracing.util;

import org.springframework.stereotype.Component;

@Component
public class DistanceUtil {

    public Double distanceBetween(Double aLatitude, Double aLongitude, Double bLatitude, Double bLongitude) {

        double theta = aLongitude - bLongitude;
        double distance = Math.sin(degToRad(aLatitude)) * Math.sin(degToRad(bLatitude))
                + Math.cos(degToRad(aLatitude)) * Math.cos(degToRad(bLatitude)) * Math.cos(degToRad(theta));

        return radToDeg(Math.cos(distance)) * 60 * 1.1515 * 1.609344;
    }

    private Double degToRad(Double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double radToDeg(Double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
