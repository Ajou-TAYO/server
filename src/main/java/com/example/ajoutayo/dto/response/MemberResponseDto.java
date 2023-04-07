package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.Member;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String email;

    public MemberResponseDto(Member entity) {
        this.email = entity.getEmail();
    }
}
