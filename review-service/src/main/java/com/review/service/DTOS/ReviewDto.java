package com.review.service.DTOS;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Long id;

    private String content;

    private Double rating;

    private Long bookingId;

    private Date createdAt;

    private Date updatedAt;
}
