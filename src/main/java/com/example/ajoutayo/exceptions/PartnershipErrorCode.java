package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum PartnershipErrorCode implements ErrorCode {
    PARTNERSHIP_NOT_EXIST(HttpStatus.NOT_FOUND, "제휴업체 정보를 찾을 수 없습니다.");
    private final HttpStatus httpStatus;
    private final String message;
}
