package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.BusStop;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusStopResponseDto {
    private long locationId;
    private String name;
    private BigDecimal lat;
    private BigDecimal lng;
    public BusStopResponseDto(BusStop entity){
        this.locationId = entity.getId();
        this.lat = entity.getLat();
        this.lng = entity.getLng();
        this.name = entity.getName();
    }
}
