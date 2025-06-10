package com.entity.service.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
