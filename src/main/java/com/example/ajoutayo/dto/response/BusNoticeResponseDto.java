package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.BusNotice;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusNoticeResponseDto {
    private long busNoticeId;
    private String title;
    private String url;
    public BusNoticeResponseDto(BusNotice entity) {
        this.busNoticeId = entity.getBusNoticeId();
        this.title = entity.getTitle();
        this.url = entity.getUrl();
    }
}
