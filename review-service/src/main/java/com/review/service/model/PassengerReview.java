package com.review.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PassengerReview extends Review {

    @Column(nullable = false)
    protected  String passengerReviewContent;

    @Column(nullable = false)
    protected String  passengerRating;
}
