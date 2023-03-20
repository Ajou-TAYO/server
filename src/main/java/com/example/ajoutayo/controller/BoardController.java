package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.model.dto.BoardDto;
import com.example.ajoutayo.service.BoardService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void uploadBoard(BoardDto board) {
        boardService.uploadBoard(board);
    }
}
