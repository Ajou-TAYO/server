package com.example.ajoutayo.dto;

import com.example.ajoutayo.domain.Board;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateBoardDto {
    private String title;
    private String content;
    private int count;
    private long userId;
    @CreatedDate
    private LocalDateTime createdAt;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .userId(0)
                .count(0)
                .build();
    }
}
