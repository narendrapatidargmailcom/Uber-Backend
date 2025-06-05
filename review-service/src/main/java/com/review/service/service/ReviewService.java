package com.review.service.service;

import com.review.service.model.Booking;
import com.review.service.model.Driver;
import com.review.service.model.Review;
import com.review.service.repositories.BookingRepository;
import com.review.service.repositories.DriverRepository;
import com.review.service.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Review r = Review.builder()
                .content("Good Ride")
                .rating(4.0)
                 .content("")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        ArrayList<Long> al = new ArrayList<>(Arrays.asList(1L,2L,3L));

       List<Driver> drivers= driverRepository.findAllById(al);

       for(Driver d : drivers){
            List<Booking> b1= d.getReviews();
            b1.forEach(b-> System.out.println(b.getId()));
       }
        //driverRepository.findById(1L);

    }
}
