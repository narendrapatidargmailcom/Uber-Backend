package com.entity.service.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTP extends BaseModel{

    private String code;

    private String sentToNumber;

    public static OTP make(String phoneNumber){
        Random random = new Random();
        Integer code = random.nextInt(999) + 1000;

        return OTP.builder()
                .sentToNumber(phoneNumber)
                .code(code.toString())
                .build();
    }
}
