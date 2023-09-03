package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    INACTIVE_USER(HttpStatus.FORBIDDEN, "비활성화 상태인 유저입니다."),
    DUP_EMAIL(HttpStatus.BAD_REQUEST, "이미 가입한 이메일입니다."),
    NOT_AJOU_EMAIL(HttpStatus.BAD_REQUEST, "아주대학교 이메일이 아닙니다."),
    EMAIL_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "이메일 전송 실패"),
    WRONG_VERIFICATION_CODE(HttpStatus.BAD_REQUEST, "인증 코드가 올바르지 않거나 만료되었습니다."),


    NOT_MATCHING_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호 재입력 실패"),
    INVALID_TOCKEN(HttpStatus.UNAUTHORIZED, "JWT 토큰이 잘못되었습니다."),
    EXPIRED_TOCKEN(HttpStatus.UNAUTHORIZED, "만료된 JWT 토큰입니다."),
    UNSUPPORTED_TOCKEN(HttpStatus.UNAUTHORIZED, "지원되지 않는 JWT 토큰입니다."),

    ;

    private final HttpStatus httpStatus;
    private final String message;
}