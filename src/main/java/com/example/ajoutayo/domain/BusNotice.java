package com.example.ajoutayo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BusNotice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long busNoticeId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

}
