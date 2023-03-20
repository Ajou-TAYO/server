package com.example.ajoutayo.model.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    private String content;
    private int viewCount;

    @CreatedDate
    private Timestamp createdDate;
    @LastModifiedDate
    private Timestamp modifiedDate;

    private Long memberId;
}

