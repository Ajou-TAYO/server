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
    private long userId;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .userId(0)
                .updatedAt(LocalDateTime.now())
                .count(0)
                .build();
    }
}
