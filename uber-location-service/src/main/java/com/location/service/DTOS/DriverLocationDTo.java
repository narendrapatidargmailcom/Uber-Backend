package com.location.service.DTOS;

import lombok.*;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class DriverLocationDTo {

        private String driverId;

        private Double latitude;

        private Double longitude;
    }


