package com.example.ajoutayo.domain;

import com.example.ajoutayo.infrastructure.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum LocationType implements EnumMapperType {
    //버스 정류장
    BUS_STOP("버스 정류장"),

    //제휴 업체
    RESTAURANT( "일반음식점"),
    CAFE("카페/디저트"), //교내시설도 포함
    PUB("주점"),
    ENTERTAINMENT("엔터테이먼트"),
    BEAUTY("뷰티"),
    HEALTH("의료/건강"),
    ETC("기타"),


    //교내시설
    FACILITIES("편의시설"),
    PRINTER("프린터"),
    CAFETERIA("교내식당"),
    STORE("편의점"),
    VENDING("자판기");

    private String title ;
    @Override
    public String getCode(){
        return name();
    }


}