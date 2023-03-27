package com.example.ajoutayo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BoardUpdateDto {
    private String title;
    private String content;
}
