package com.entity.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reviews"})
public class Driver extends BaseModel {

    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    private String adharNumber;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private  ExactLocation lastKnownLocation;

    @OneToOne
    private  ExactLocation home;

    private String activeCity;

    private boolean isAvailable;

    @DecimalMin(value= "0.00",message="Rating must be ggreter than or equals to 0")
    @DecimalMax(value= "5.00",message="Rating must be less than or equals to 5")
    private  double rating;

    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> reviews = new ArrayList<>();
}
