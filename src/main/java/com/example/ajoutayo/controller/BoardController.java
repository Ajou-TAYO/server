package com.example.ajoutayo.controller;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.BoardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response){
        boardService.viewCount(id, request, response); // views ++
        BoardResponseDto board= boardService.getBoard(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_BOARD,board));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id){
        boardService.deleteBoard(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.DELETE_BOARD));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable("id") Long id, @RequestBody BoardUpdateDto boardUpdateDto){
        BoardResponseDto board= boardService.updateBoard(id, boardUpdateDto);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.UPDATE_BOARD,board));
    }
    @PostMapping("/new")
    public ResponseEntity<?> createBoard(@RequestBody BoardCreateDto boardCreateDto) {
        Long boardId = boardService.saveBoard(boardCreateDto);
        BoardResponseDto board= boardService.getBoard(boardId);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.CREATE_BOARD,board));

    }
    @GetMapping("")
    public ResponseEntity<?>  getAllBoards() {
        List<Board> boardList = boardService.getAllBoards();
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_ALL_BOARD, boardList));
    }

}
