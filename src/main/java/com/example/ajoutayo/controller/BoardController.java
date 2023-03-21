package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.dto.BoardDto;
import com.example.ajoutayo.service.BoardService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards/**")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/")
    public List<BoardDto> getAllBoards() {

        return boardService.getAllBoardList();
    }

    @PostMapping("/upload")
    public void uploadBoard(@RequestBody BoardDto boardDto) {
        boardService.uploadBoard(boardDto);
    }
}
