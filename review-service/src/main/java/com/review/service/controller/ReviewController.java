package com.review.service.controller;

import com.review.service.DTOS.CreateReviewDto;
import com.review.service.DTOS.ReviewDto;
import com.review.service.adaptors.CreateReviewDtoToReviewAdaptor;
import com.review.service.model.Review;
import com.review.service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CreateReviewDtoToReviewAdaptor createReviewDtoToReviewAdaptor;


    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto createReviewDto){

        Review incommingReview=createReviewDtoToReviewAdaptor.convertDto(createReviewDto);
        if(incommingReview == null){
            return new ResponseEntity<>("Review is null", HttpStatus.BAD_REQUEST);
        }
        System.out.println(incommingReview);
        Review review = reviewService.publishReview(incommingReview);

        ReviewDto reviewDto = ReviewDto.builder()
                .id(review.getId())
                .updatedAt(review.getUpdatedAt())
                .createdAt(review.getCreatedAt())
                .rating(review.getRating())
                .content(review.getContent())
                .build();

        return new ResponseEntity<>(reviewDto,HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId){
            Optional<Review> review =reviewService.findReviewById(reviewId);
       return new ResponseEntity<>(review,HttpStatus.OK);
    }

}
