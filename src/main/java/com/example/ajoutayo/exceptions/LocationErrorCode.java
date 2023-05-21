package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum LocationErrorCode implements ErrorCode {
    BUS_NOT_FOUND(HttpStatus.NOT_FOUND, "버스 정보를 찾을 수 없습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
