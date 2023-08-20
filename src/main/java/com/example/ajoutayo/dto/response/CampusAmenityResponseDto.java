package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.CampusAmenity;
import com.example.ajoutayo.domain.LocationType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampusAmenityResponseDto {
    private long amenityId;
    private LocationType category;
    private String name;
    private String detail;
    private String image;
    private BigDecimal lat;
    private BigDecimal lng;
    public CampusAmenityResponseDto(CampusAmenity entity){
        this.amenityId= entity.getAmenity_id();
        this.name= entity.getName();
        this.image=entity.getImage();
        this.category = entity.getCategory();
        this.detail= entity.getDetail();
        this.lat=entity.getLat();
        this.lng=entity.getLng();
    }
}
