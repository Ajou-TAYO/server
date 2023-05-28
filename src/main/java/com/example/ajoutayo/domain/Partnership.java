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
    @Id
    @Column(name="partnership_id")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Enumerated(value= EnumType.STRING)
    @Column()
    private LocationType category;
    @Column()
    private String expired;
    @Column(nullable = false)
    private String detail;
    @Column(nullable = false)
    private BigDecimal lat;
    @Column(nullable = false)
    private BigDecimal lng;



}

