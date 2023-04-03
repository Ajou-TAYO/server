package com.example.ajoutayo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomApiException extends RuntimeException {
    private final ErrorCode errorCode;
}
