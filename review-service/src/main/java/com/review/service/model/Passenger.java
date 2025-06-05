package com.review.service.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> reviews = new ArrayList<>();
}
