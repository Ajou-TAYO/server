package com.example.ajoutayo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long boardId;
    private String title;
    private String content;
    private Integer count;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Board createBoard(String title, String content ){
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        return board;
    }

}