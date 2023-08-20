package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.BusNotice;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.BusNoticeResponseDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.BusNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus/notices")
public class BusNoticeController {
    private final BusNoticeService busNoticeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBusNotice(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response){
        BusNoticeResponseDto busNotice= busNoticeService.getBusNotice(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_BUS_NOTICE, busNotice));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllBusNoticesOrderByDesc() {
        List<BusNotice> busNoticeList = busNoticeService.getAllBusNoticesOrderByDesc();
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_ALL_BUS_NOTICE_BY_DESC, busNoticeList));
    }

}
