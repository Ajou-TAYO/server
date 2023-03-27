package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.CreateBoardDto;
import com.example.ajoutayo.dto.response.BoardDto;
import com.example.ajoutayo.service.BoardService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/{id}")
    public BoardDto getBoard(@PathVariable("id") Long id){
        return boardService.getBoard(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id") Long id){
        boardService.deleteBoard(id);
    }
    @PostMapping("/new")
    public Long createBoard(@RequestBody CreateBoardDto boardDto) {
        return boardService.saveBoard(boardDto);
    }
    @GetMapping("")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

}
