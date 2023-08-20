package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum NoticeErrorCode implements ErrorCode {
    NOT_MATCH_ROLE(HttpStatus.FORBIDDEN, "해당 작업에 대한 권한이 없습니다."),
    NOTICE_NOT_EXIST(HttpStatus.NOT_FOUND, "해당 공지사항이 존재하지 않습니다.");
    private final HttpStatus httpStatus;
    private final String message;

}
