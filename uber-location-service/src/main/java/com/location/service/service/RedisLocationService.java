package com.location.service.service;

import com.location.service.DTOS.DriverLocationDTo;
import com.location.service.DTOS.NearByDriverRequest;
import com.location.service.DTOS.SaveDriverLocationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisLocationService {

    private static final String DRIVER_GEO_OPS_KEY=" drivers";

    private static final double SEARCH_RADIUS=100.0;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Boolean saveDriverLocation(String driverId, Double latitude, Double longitude) {
        GeoOperations<String, String> geoOps = stringRedisTemplate.opsForGeo();
        geoOps.add(
                DRIVER_GEO_OPS_KEY,
                new RedisGeoCommands.GeoLocation<>(
                        driverId,
                        new Point(
                                latitude,
                                longitude)));
        return true;
    }


    public List<DriverLocationDTo> getNearByDrivers(Double latitude, Double longitude) {
        GeoOperations<String, String> geoOps = stringRedisTemplate.opsForGeo();
        Distance radius = new Distance(SEARCH_RADIUS, Metrics.KILOMETERS);
        Circle within = new Circle(new Point(latitude, longitude), radius);

        GeoResults<RedisGeoCommands.GeoLocation<String>> results = geoOps.radius(DRIVER_GEO_OPS_KEY, within);
        List<DriverLocationDTo> drivers = new ArrayList<>();
        for(GeoResult<RedisGeoCommands.GeoLocation<String>> result : results) {
            Point point = geoOps.position(DRIVER_GEO_OPS_KEY, result.getContent().getName()).get(0);
            DriverLocationDTo driverLocation = DriverLocationDTo.builder()
                    .driverId(result.getContent().getName())
                    .latitude(point.getX())
                    .longitude(point.getY())
                    .build();
            drivers.add(driverLocation);
        }
        return drivers;
    }
}
