package com.entity.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Inheritance(strategy =  InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Booking booking;  //

//    @LastModifiedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false)
//    protected Date updatedAt;
//
//    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP) // TemporalType.TIMESTAMP store the date with time
//    @Column(nullable = false)
//    protected Date createdAt;



}
