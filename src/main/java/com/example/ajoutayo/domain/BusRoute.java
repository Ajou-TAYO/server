package com.example.ajoutayo.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BusRoute {
    @Id
    @Column(name="bus_route_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String type;

    @Column(nullable = false, length = 15)
    private String name;
    @Column(nullable = false)
    private String departmentTimeList;

    @OneToOne(cascade = CascadeType.DETACH, fetch = EAGER)
    @JoinColumn(name="dep_bus_stop_id")
    private BusStop depBusStop;
    @OneToOne(cascade = CascadeType.DETACH, fetch = EAGER)
    @JoinColumn(name="mid_bus_stop_id")
    private BusStop midBusStop;
    @OneToOne(cascade = CascadeType.DETACH, fetch = EAGER)
    @JoinColumn(name="arr_bus_stop_id")
    private BusStop arrBusStop;

}
