package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.BusNotice;
import com.example.ajoutayo.dto.response.BusNoticeResponseDto;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.exceptions.NoticeErrorCode;
import com.example.ajoutayo.infrastructure.BusNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BusNoticeService {
    @Autowired
    private final BusNoticeRepository busNoticeRepository;

    @Transactional(readOnly = true)
    public BusNoticeResponseDto getBusNotice(Long busNoticeId) {
        BusNotice busNotice = busNoticeRepository.findById(busNoticeId).orElseThrow(()
                -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));

        return new BusNoticeResponseDto(busNotice);
    }

    public List<BusNotice> getAllBusNoticesOrderByDesc() {
        List<BusNotice> busNoticeList = busNoticeRepository.findAllByOrderByUrlDesc();
        return busNoticeList;

    }
}
