package com.entity.service.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reviews"})
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String phoneNumner;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> reviews = new ArrayList<>();

    @OneToOne
    private Booking activeBooking;

    @DecimalMin(value= "0.00",message="Rating must be ggreter than or equals to 0")
    @DecimalMax(value= "5.00",message="Rating must be less than or equals to 5")
    private  double rating;

    @OneToOne
    private ExactLocation lastKnowlocation;

    @OneToOne
    private ExactLocation home;
}
