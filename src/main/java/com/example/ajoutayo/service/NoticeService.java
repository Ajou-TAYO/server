package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Notice;
import com.example.ajoutayo.dto.request.NoticeCreateDto;
import com.example.ajoutayo.dto.request.NoticeUpdateDto;
import com.example.ajoutayo.dto.response.NoticeResponseDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NoticeService {
    NoticeResponseDto getLatestNotice();
    NoticeResponseDto getNotice(Long noticeId);
    Long saveNotice(NoticeCreateDto createNoticeCreateDto, String userDetails);
    List<Notice> getAllNotices();
    List<Notice> getNoticesByKeyWord(String keyword);
    void viewCount(Long noticeId, HttpServletRequest request, HttpServletResponse response);
    NoticeResponseDto updateNotice(Long noticeId, String nickname, NoticeUpdateDto noticeUpdateDto);
    void deleteNotice(Long noticeId, String nickname);

}
