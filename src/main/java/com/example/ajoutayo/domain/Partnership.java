package com.example.ajoutayo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Partnership {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long partnership_id;

    @Column(nullable = false)
    private String name;
    @Enumerated(value= EnumType.STRING)
    @Column()
    private LocationType category;
    @Column(nullable = true)
    private String image;
    @Column()
    private String expired;
    @Column(nullable = false)
    private String detail;
    @Column(nullable = false, precision = 18, scale = 14)
    private BigDecimal lat;
    @Column(nullable = false, precision = 18, scale = 14)
    private BigDecimal lng;

}

