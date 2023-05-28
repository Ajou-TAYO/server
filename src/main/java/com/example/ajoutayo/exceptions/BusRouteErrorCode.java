package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BusRouteErrorCode implements ErrorCode {
    BUS_ROUTE_NOT_EXIST(HttpStatus.NOT_FOUND, "해당 노선이 존재하지 않습니다.");
    private final HttpStatus httpStatus;
    private final String message;

}