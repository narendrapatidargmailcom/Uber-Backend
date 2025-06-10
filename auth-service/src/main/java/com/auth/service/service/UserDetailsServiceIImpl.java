package com.auth.service.service;

import com.auth.service.repository.PassengerRepository;
import com.auth.service.security.AuthPassengerDetail;
import com.entity.service.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceIImpl implements UserDetailsService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email);

       if (passenger.isPresent()){
           return new AuthPassengerDetail(passenger.get());
       }else {
           throw new UsernameNotFoundException("user not found with email");
       }

    }
}
