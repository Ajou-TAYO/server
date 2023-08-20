package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Notice;
import com.example.ajoutayo.dto.request.NoticeCreateDto;
import com.example.ajoutayo.dto.request.NoticeUpdateDto;
import com.example.ajoutayo.dto.response.NoticeResponseDto;
import com.example.ajoutayo.exceptions.NoticeErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.infrastructure.NoticeRepository;

import com.example.ajoutayo.infrastructure.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private final NoticeRepository noticeRepository;
    @Autowired
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public NoticeResponseDto getLatestNotice() {
        Notice notice = noticeRepository.findTopByOrderByUpdatedAtDesc().orElseThrow(()
                -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));
        return new NoticeResponseDto(notice);
    }

    @Override
    @Transactional(readOnly = true)
    public NoticeResponseDto getNotice(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(()
                -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));

        return new NoticeResponseDto(notice);
    }

    @Override
    @Transactional
    public void deleteNotice(Long noticeId, String nickname) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(()
                -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));
        if(!notice.getNickname().equals(nickname)){
            throw new CustomApiException(NoticeErrorCode.NOT_MATCH_ROLE);
        }
        noticeRepository.deleteById(noticeId);
    }

    @Override
    @Transactional
    public Long saveNotice(NoticeCreateDto noticeCreateDto, String email) {
        String nickname = email.substring(0, email.indexOf("@"));

        Notice notice =  noticeRepository.save(noticeCreateDto.toEntity());
        notice.saveNickname(nickname);

        return notice.getNoticeId();
    }
    @Override
    @Transactional
    public NoticeResponseDto updateNotice(Long noticeId, String nickname, NoticeUpdateDto noticeUpdateDto) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(()
                -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));
        if(!notice.getNickname().equals(nickname)){
            throw new CustomApiException(NoticeErrorCode.NOT_MATCH_ROLE);
        }
        notice.update(noticeUpdateDto.getTitle(), noticeUpdateDto.getContent());
        return new NoticeResponseDto(notice);
    }
    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }
    @Override
    @Transactional
    public List<Notice> getNoticesByKeyWord(String keyword) {
        List<Notice> noticeList = noticeRepository.findByTitleContaining(keyword);
        return noticeList;
    }

    @Override
    @Transactional
    public void viewCount(Long noticeId, HttpServletRequest request, HttpServletResponse response) {
        Cookie oldCookie = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("noticeView")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + noticeId.toString() + "]")) {
                Notice notice = noticeRepository.findById(noticeId).orElseThrow(()
                        -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));
                notice.viewCountUp(notice);

                oldCookie.setValue(oldCookie.getValue() + "_[" + noticeId + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            Notice notice = noticeRepository.findById(noticeId).orElseThrow(()
                    -> new CustomApiException(NoticeErrorCode.NOTICE_NOT_EXIST));
            notice.viewCountUp(notice);

            Cookie newCookie = new Cookie("noticeView", "[" + noticeId + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }
}