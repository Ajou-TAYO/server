package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;
import com.example.ajoutayo.service.BoardService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable("id") Long id){
        return boardService.getBoard(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id") Long id){
        boardService.deleteBoard(id);
    }
    @PutMapping("/{id}")
    public BoardResponseDto updateBoard(@PathVariable("id") Long id, @RequestBody BoardUpdateDto boardUpdateDto){
        return boardService.updateBoard(id, boardUpdateDto);
    }
    @PostMapping("/new")
    public Long createBoard(@RequestBody BoardCreateDto boardCreateDto) {
        return boardService.saveBoard(boardCreateDto);
    }
    @GetMapping("")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

}
