package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.Partnership;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnershipResponseDto {
    private long partnershipId;
    private String name;
    private String detail;
    private BigDecimal lat;
    private BigDecimal lng;

    public PartnershipResponseDto(Partnership entity){
        this.partnershipId= entity.getId();
        this.name= entity.getName();
        this.detail= entity.getDetail();
        this.lat=entity.getLat();
        this.lng=entity.getLng();
    }
}
