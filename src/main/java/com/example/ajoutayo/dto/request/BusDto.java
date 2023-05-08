package com.example.ajoutayo.dto.request;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusDto implements Serializable {
    private double x;
    private double y;
    private Timestamp time;
}