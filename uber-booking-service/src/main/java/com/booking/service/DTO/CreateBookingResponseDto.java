package com.booking.service.DTO;


import com.entity.service.model.Driver;
import lombok.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateBookingResponseDto {

    private long bookingId;

    private  String bookingStatus;

    private Driver driver;
}
