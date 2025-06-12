package com.booking.service.services;

import com.booking.service.DTO.CreateBookingResponseDto;
import com.booking.service.DTO.DriverLocationDTo;
import com.booking.service.DTO.createBookingDTO;
import com.booking.service.Repository.BookingRepository;
import com.booking.service.Repository.PassengerRepository;
import com.entity.service.model.Booking;
import com.entity.service.model.BookingType;
import com.entity.service.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BookingServiceImpl implements BookingService{

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String LOCATION_SERVICE="http://localhost:7777";

    @Override
    public CreateBookingResponseDto createBooking(createBookingDTO createBookingDTO) {
        Passenger passenger =passengerRepository.findById(createBookingDTO.getPassengerId()).get();
        Booking booking = Booking.builder()
                .bookingType(BookingType.ASSIGNING_DRIVER)
                .startLocation(createBookingDTO.getStartLocation())
                .endLocation(createBookingDTO.getEndLocation())
                .passenger(passenger)
                .build();

        ResponseEntity<List<DriverLocationDTo>> result= restTemplate.getForObject(LOCATION_SERVICE+"api/location/nearby/driver",ResponseEntity.class );

       Booking savedBooking= bookingRepository.save(booking);
       return CreateBookingResponseDto.builder()
               .bookingId(savedBooking.getId())
               .bookingStatus(savedBooking.getBookingType().toString())
               .driver(savedBooking.getDriver())
               .build();
    }
}
