package com.example.ajoutayo.domain;

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
    private Integer count;
    private Long userId;
    //private LocalDateTime createdAt;
    //private LocalDateTime updatedAt;

}