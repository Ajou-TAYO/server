package com.example.ajoutayo.exceptions;

import com.example.ajoutayo.dto.StatusCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BoardErrorCode implements ErrorCode {
    BOARD_NOT_EXIST(HttpStatus.NOT_FOUND, "해당 게시물이 존재하지 않습니다.");
    private final HttpStatus httpStatus;
    private final String message;

}
