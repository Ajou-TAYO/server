package com.example.ajoutayo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LocationType {
    //버스 정류장
    BUS_STOP("버스 정류장"),
    //제휴 업체
    CAFE("카페"),
    RESTAURANT("식당"),
    FACILITIES("편의시설"),
    PUB("술집"),
    //교내시설
    PRINTER("프린터"),
    CAFETERIA("교내식당"),
    CONVENIENCE_STORE("편의점"),
    PARK("주차장");
    private String type ;
}