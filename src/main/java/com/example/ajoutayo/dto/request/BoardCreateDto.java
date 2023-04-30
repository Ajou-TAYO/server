package com.example.ajoutayo.dto.request;

import com.example.ajoutayo.domain.Board;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardCreateDto {
    @NotNull
    private String title;
    @NotNull
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .updatedAt(LocalDateTime.now())
                .count(0)
                .build();
    }

}
