package com.booking.service.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NearByDriverRequest {

    private Double latitude;

    private Double longitude;
}
