package com.example.ajoutayo.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BusRoute {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BusRouteType type;

    @Column(nullable = false, length = 15)
    private String name;
    @Column(nullable = false)
    private String departmentTimeList;

    @JoinColumn(name="dep_bus_stop")
    @OneToOne(cascade = CascadeType.DETACH, fetch = LAZY)
    private BusStop depBusStop;
    @JoinColumn(name="arr_bus_stop")
    @OneToOne(cascade = CascadeType.DETACH, fetch = LAZY)
    private BusStop arrBusStop;

}
