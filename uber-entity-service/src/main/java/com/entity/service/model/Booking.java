package com.entity.service.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(indexes = {
//            @Index(columnList = "driver_id")
//})
public class Booking  extends BaseModel{

    @Enumerated(EnumType.STRING)
    private BookingType bookingType;

    //@Temporal(TemporalType.DATE)  // TemporalType.DATE store the date without time
    @Temporal(TemporalType.TIMESTAMP)  // TemporalType.TIMESTAMP store the date with time
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @OneToOne
    private ExactLocation startLocation;

    @OneToOne
    private ExactLocation endLocation;

}
