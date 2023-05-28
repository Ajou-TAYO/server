package com.example.ajoutayo.dto;

import com.example.ajoutayo.infrastructure.EnumMapperType;
import lombok.Getter;

@Getter
public class EnumMapperValue {
    private int code;
    private String type;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        type = enumMapperType.getType();
    }

}
