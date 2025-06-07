package com.auth.service.DTOS;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PassengerSignupRequest {


    private String name;

    private String phoneNumber;

    private String password;

    private String email;
}
