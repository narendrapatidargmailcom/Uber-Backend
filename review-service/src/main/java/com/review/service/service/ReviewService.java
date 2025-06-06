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

import java.util.*;

@Service
public class ReviewService  {

    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }
}
