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
    BUS_STOP(0,"버스 정류장"),

    //제휴 업체
    RESTAURANT(1, "일반음식점"),
    CAFE(2, "카페/디저트"),
    PUB(3, "주점"),
    ENTERTAINMENT(4,"엔터테이먼트"),
    BEAUTIY(5,"뷰티"),
    HEALTH(6,"의료/건강"),
    ETC(7,"기타"),


    //교내시설
    //FACILITIES(8,"편의시설"),
    PRINTER(8,"프린터"),
    CAFETERIA(9,"교내식당"),
    CONVENIENCE_STORE(10,"편의점"),
    PARK(11,"주차장");
    private int code;
    private String type ;
    @Override
    public String getName(){
        return name();
    }

}