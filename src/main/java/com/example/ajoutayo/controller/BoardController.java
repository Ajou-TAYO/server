package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.*;
import com.example.ajoutayo.service.BoardService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards/**")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/")
    public List<Board> getAllBoards() {

        return boardService.getAllBoards();
    }

    @PostMapping("/upload")
    public void createBoard(@RequestBody CreateBoardDto createBoardDto) {
        boardService.saveBoard(createBoardDto);
    }
}
