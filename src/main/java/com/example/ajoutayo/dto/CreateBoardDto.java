package com.example.ajoutayo.dto;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class CreateBoardDto {
    private String title;
    private String content;
    private Long userId;
    @CreatedDate
    private LocalDateTime createdAt;
}
