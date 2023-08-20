package com.example.ajoutayo.dto.response;

import com.example.ajoutayo.domain.BusNotice;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusNoticeResponseDto {
    private long busNoticeId;
    private String url;
    public BusNoticeResponseDto(BusNotice entity) {
        this.busNoticeId = entity.getBusNoticeId();
        this.url = entity.getUrl();
    }
}
