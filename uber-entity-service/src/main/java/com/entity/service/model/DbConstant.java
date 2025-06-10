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
public class DbConstant extends BaseModel{

    @Column(unique = true,nullable = false)
    private String name;

    private String value;

}
