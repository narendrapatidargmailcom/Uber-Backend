package com.auth.service.DTOS;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerLoginRequest {
    private String email;
    private String password;
}

