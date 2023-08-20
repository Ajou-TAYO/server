package com.example.ajoutayo.dto.request;

import com.example.ajoutayo.domain.Notice;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class NoticeCreateDto {
    @NotNull
    private String title;
    @NotNull
    private String content;

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .updatedAt(LocalDateTime.now())
                .count(0)
                .build();
    }

}
