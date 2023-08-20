package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.Notice;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDto {
    private long noticeId;
    private String title;
    private String content;
    private int count;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public NoticeResponseDto(Notice entity) {
        this.noticeId = entity.getNoticeId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.count = entity.getCount();
        this.nickname = entity.getNickname();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

}

