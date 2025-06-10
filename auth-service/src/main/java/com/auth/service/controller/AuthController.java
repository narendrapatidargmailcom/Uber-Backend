package com.auth.service.controller;

import com.auth.service.DTOS.PassengerLoginRequest;
import com.auth.service.DTOS.PassengerSignupRequest;
import com.auth.service.service.AuthService;
import com.auth.service.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup/passenger")
    public ResponseEntity<?> singnUp(@RequestBody PassengerSignupRequest passengerSignupRequest){
        return new ResponseEntity<>(authService.signupPassenger(passengerSignupRequest), HttpStatus.OK);
    }

    @PostMapping("/signin/passenger")
    public ResponseEntity<?> singnIn(@RequestBody PassengerLoginRequest loginRequest, HttpServletResponse httpServletResponse){
        System.out.println("inside the controller");
        Authentication authentication =authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        if (authentication.isAuthenticated()){
            String token=jwtService.generateToken(loginRequest.getEmail());
            ResponseCookie responseCookie = ResponseCookie.from("JwtToken",token)
                    .httpOnly(false)
                    .secure(false)
                    .maxAge(7*24*3600)
                    .path("/")
                    .build();
            httpServletResponse.setHeader(HttpHeaders.SET_COOKIE,responseCookie.toString());
            return new ResponseEntity<>("token->"+token,HttpStatus.OK);
        }
        return new ResponseEntity<>("Auth is not  sucess",HttpStatus.OK);
    }

    @GetMapping("/validate")
     public ResponseEntity<?> validate(HttpServletRequest httpServletRequest){
        for(Cookie cookie:httpServletRequest.getCookies()){
            System.out.println(cookie.getName());
        }
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
