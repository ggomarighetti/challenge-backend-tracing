package com.ggomarighetti.tracing.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Component
public class TimezoneMapper {

    //Help method to obtain the time and names of each time zone and group them in a map.
    public Map<String, String> timezonesListToTimezonesMap(List<String> timezones){
        Map<String, String> timezonesMap = new HashMap<>();

        for (String timezone : timezones){

            TimeZone tz = TimeZone.getDefault();
            tz.setID(timezone);
            timezonesMap.put(timezone, LocalDateTime.now(tz.toZoneId()).toString());
        }

        return timezonesMap;
    }
}
