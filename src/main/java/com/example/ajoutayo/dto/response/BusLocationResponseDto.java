package com.example.ajoutayo.dto.response;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusLocationResponseDto implements Serializable {
    //private String busId; //bus01, bus02, bus03
    private double x;
    private double y;
    private Timestamp time;
}