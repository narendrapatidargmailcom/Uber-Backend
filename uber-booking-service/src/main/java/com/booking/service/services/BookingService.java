package com.booking.service.services;

import com.booking.service.DTO.CreateBookingResponseDto;
import com.booking.service.DTO.createBookingDTO;
import com.entity.service.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
   public CreateBookingResponseDto createBooking(createBookingDTO createBookingDTO);
}
