package com.booking.service.DTO;

import com.entity.service.model.BookingType;
import com.entity.service.model.Driver;
import com.entity.service.model.ExactLocation;
import com.entity.service.model.Passenger;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class createBookingDTO {


    private BookingType bookingType;


    private Date startTime;


    private Date endTime;

    private Long totalDistance;


    private Long passengerId;


    private Driver driver;


    private ExactLocation startLocation;


    private ExactLocation endLocation;

}
