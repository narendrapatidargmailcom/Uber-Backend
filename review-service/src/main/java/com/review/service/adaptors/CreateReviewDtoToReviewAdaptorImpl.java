package com.review.service.adaptors;

import com.review.service.DTOS.CreateReviewDto;
import com.review.service.model.Booking;
import com.review.service.model.Review;
import com.review.service.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdaptorImpl implements  CreateReviewDtoToReviewAdaptor{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {

       Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        System.out.println(booking.get());
         if(booking.isEmpty()){
             return  null;
         }
            return  Review.builder()
                     .booking(booking.get())
                     .content(createReviewDto.getContent())
                     .rating(createReviewDto.getRating())
                     .build();


    }
}
