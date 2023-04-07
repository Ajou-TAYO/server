package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.Board;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private long boardId;
    private String title;
    private String content;
    private int count;
    private long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardResponseDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.count = entity.getCount();
        this.userId = entity.getUserId();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

}

