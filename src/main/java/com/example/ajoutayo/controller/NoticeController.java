package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.domain.Notice;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.request.NoticeCreateDto;
import com.example.ajoutayo.dto.request.NoticeUpdateDto;
import com.example.ajoutayo.dto.response.NoticeResponseDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.NoticeService;

import com.example.ajoutayo.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notices")
public class NoticeController {
    private final NoticeService noticeService;
    private final MemberService memberService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestNotice(){
        NoticeResponseDto notice= noticeService.getLatestNotice();
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_LATEST_NOTICE, notice));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNotice(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response){
        noticeService.viewCount(id, request, response); // views ++
        NoticeResponseDto notice= noticeService.getNotice(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_NOTICE, notice));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotice(@PathVariable("id") Long id){
        String nickname = memberService.getNicknameWithAuth();
        noticeService.deleteNotice(id, nickname);

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.DELETE_NOTICE));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateNotice(@PathVariable("id") Long id, @RequestBody NoticeUpdateDto noticeUpdateDto){
        String nickname = memberService.getNicknameWithAuth();
        NoticeResponseDto notice= noticeService.updateNotice(id, nickname, noticeUpdateDto);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.UPDATE_NOTICE, notice));
    }
    @PostMapping("/new")
    public ResponseEntity<?> createNotice(Authentication authentication, @RequestBody NoticeCreateDto noticeCreateDto) {
        Long noticeId = noticeService.saveNotice(noticeCreateDto, authentication.getName());
        NoticeResponseDto notice= noticeService.getNotice(noticeId);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.CREATE_NOTICE, notice));

    }
    @GetMapping("")
    public ResponseEntity<?>  getAllNotices(String search) {
        List<Notice> noticeList = null;
        String response = null;
        if(search==null) {
            noticeList = noticeService.getAllNotices();
            response=ResponseMessage.GET_ALL_NOTICE;

        }else{
            noticeList = noticeService.getNoticesByKeyWord(search);
            response=ResponseMessage.SEARCH_SUCCESS;
        }
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, response, noticeList));
    }

}
