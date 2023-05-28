package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BusStopErrorCode implements ErrorCode {
    BUS_STOP_NOT_EXIST(HttpStatus.NOT_FOUND, "해당 정류장이 존재하지 않습니다.");
    private final HttpStatus httpStatus;
    private final String message;

}
