package com.example.ajoutayo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BusStop {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, unique = true, nullable = false, length = 15)
    private String name;

    @Column(nullable = false)
    private BigDecimal lat;
    private BigDecimal lng;

    @Column(nullable = true)
    private String timeTable;


}
