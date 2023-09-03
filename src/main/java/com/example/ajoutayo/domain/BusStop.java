package com.example.ajoutayo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class BusStop {
    @Id
    @Column(name="bus_stop_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, unique = true, nullable = false, length = 15)
    private String name;

    @Column(nullable = false, precision = 18, scale = 14)
    private BigDecimal lat;
    @Column(nullable = false, precision = 18, scale = 14)
    private BigDecimal lng;
}
