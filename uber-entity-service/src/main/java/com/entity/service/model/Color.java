package com.entity.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Color extends BaseModel{

    @Column(nullable = false,unique = true)
    private String name;
}
