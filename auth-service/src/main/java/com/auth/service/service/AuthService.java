package com.auth.service.service;

import com.auth.service.DTOS.PassengerSignupRequest;
import com.auth.service.DTOS.PassengerSignupResponse;
import com.auth.service.repository.PassengerRepository;
import com.entity.service.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public PassengerSignupResponse signupPassenger(PassengerSignupRequest passengerSignupRequest){
        Passenger passenger = Passenger.builder()
                .email(passengerSignupRequest.getEmail())
                .name(passengerSignupRequest.getName())
                .password(bCryptPasswordEncoder.encode(passengerSignupRequest.getPassword()))
                .phoneNumner(passengerSignupRequest.getPhoneNumber())
                .build();
        Passenger savedPassenger=passengerRepository.save(passenger);
        return  PassengerSignupResponse.from(savedPassenger);
    }
}
