package com.entity.service.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Car extends BaseModel{

    @OneToOne
    private Color color;

    @Column(nullable = false,unique = true)
    private String platNumber;

    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    @OneToOne
    private Driver driver;
}
