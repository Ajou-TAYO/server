package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CampusAmenityErrorCode implements ErrorCode {
    CAMPUS_AMENITY_NOT_EXIST(HttpStatus.NOT_FOUND, "캠퍼스 편의시설 정보를 찾을 수 없습니다.");
    private final HttpStatus httpStatus;
    private final String message;
}
