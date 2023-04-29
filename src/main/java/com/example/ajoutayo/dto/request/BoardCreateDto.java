package com.example.ajoutayo.dto.request;

import com.example.ajoutayo.domain.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardCreateDto {
    private String title;
    private String content;
    private int count;
    private long nickname;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .nickname("관리자")
                .updatedAt(LocalDateTime.now())
                .count(0)
                .build();
    }
}
