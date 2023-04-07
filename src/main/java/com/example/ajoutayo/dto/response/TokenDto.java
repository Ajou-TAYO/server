package com.example.ajoutayo.dto.response;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class TokenDto {

    private String grantType;
    private String accessToken;
    private String refreshToken;
}