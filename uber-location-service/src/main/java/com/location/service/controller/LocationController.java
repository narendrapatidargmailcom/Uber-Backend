package com.location.service.controller;

import com.location.service.DTOS.DriverLocationDTo;
import com.location.service.DTOS.NearByDriverRequest;
import com.location.service.DTOS.SaveDriverLocationRequest;
import com.location.service.service.RedisLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/location")
public class LocationController {

    private static final String GEO_OPS_DRIVER_KEY=" drivers";

    private static final double SEARCH_RADIUS=100.0;

    @Autowired
    private StringRedisTemplate restTemplate;

    @Autowired
    private RedisLocationService locationService;

    @PostMapping("/drivers")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody SaveDriverLocationRequest saveDriverLocationRequestDto) {
        try {
            Boolean response = locationService.saveDriverLocation(saveDriverLocationRequestDto.getDriverId(), saveDriverLocationRequestDto.getLatitude(), saveDriverLocationRequestDto.getLongitude());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @PostMapping ("/nearby/drivers")
    public ResponseEntity<List<DriverLocationDTo>> getNearbyDrivers(@RequestBody NearByDriverRequest nearbyDriversRequestDto) {
        try {
            List<DriverLocationDTo> drivers = locationService.getNearByDrivers(nearbyDriversRequestDto.getLatitude(), nearbyDriversRequestDto.getLongitude());
            return new ResponseEntity<>(drivers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
