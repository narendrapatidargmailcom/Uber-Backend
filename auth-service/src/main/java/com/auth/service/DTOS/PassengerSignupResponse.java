package com.auth.service.DTOS;

import com.auth.service.model.Passenger;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PassengerSignupResponse {

    private Long id;

    private String name;

    private String phoneNumner;

    private String password;

    private String email;

    private Date createdAt;

    public static PassengerSignupResponse from(Passenger passenger) {
        return PassengerSignupResponse.builder()
                .email(passenger.getEmail())
                .password(passenger.getPassword())
                .id(passenger.getId())
                .createdAt(passenger.getCreatedAt())
                .name(passenger.getName())
                .phoneNumner(passenger.getPhoneNumner())
                .build();
    }
}
