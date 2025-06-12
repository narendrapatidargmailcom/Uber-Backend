package com.booking.service.controller;

import com.booking.service.DTO.CreateBookingResponseDto;
import com.booking.service.DTO.createBookingDTO;
import com.booking.service.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(createBookingDTO createBookingDTO){
        bookingService.createBooking(createBookingDTO);
        return new ResponseEntity<>(bookingService.createBooking(createBookingDTO), HttpStatus.CREATED);
    }
}
