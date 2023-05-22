package com.example.ajoutayo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum BusRouteType{
    GO("등교"),
    FROM("하교");

    private String value;
}
