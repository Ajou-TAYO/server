package com.example.ajoutayo.domain;

import com.example.ajoutayo.dto.request.BoardCreateDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Board extends BaseTimeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long boardId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int count;
    @Column(nullable = true)
    private String nickname;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
    public void update(String title, String content) {
        if (title != null)
            this.title = title;
        if(content != null)
            this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public void saveNickname(String nickname){
        this.nickname = nickname;
    }
    public void viewCountUp(Board board) {
        board.count++;
    }
}