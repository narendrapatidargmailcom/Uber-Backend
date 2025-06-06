package com.review.service.adaptors;

import com.review.service.DTOS.CreateReviewDto;
import com.review.service.model.Review;

public interface CreateReviewDtoToReviewAdaptor {

    public Review convertDto(CreateReviewDto createReviewDto);
}
