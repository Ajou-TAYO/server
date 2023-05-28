package com.example.ajoutayo.infrastructure;

import lombok.AllArgsConstructor;


public interface EnumMapperType {
    // 해당 Enum의 이름을 조회하는 변수
    String getCode();

    // 해당 Enum의 설명을 조회하는 변수
    String getTitle();

}
