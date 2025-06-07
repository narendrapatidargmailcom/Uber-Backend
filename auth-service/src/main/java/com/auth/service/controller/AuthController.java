package com.auth.service.controller;

import com.auth.service.DTOS.PassengerSignupRequest;
import com.auth.service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/passenger")
    public ResponseEntity<?> singnUp(@RequestBody PassengerSignupRequest passengerSignupRequest){
        return new ResponseEntity<>(authService.signupPassenger(passengerSignupRequest), HttpStatus.OK);
    }
}
