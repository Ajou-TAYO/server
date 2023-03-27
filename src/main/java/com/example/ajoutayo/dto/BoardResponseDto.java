package com.example.ajoutayo.dto;

import com.example.ajoutayo.domain.Board;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
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

