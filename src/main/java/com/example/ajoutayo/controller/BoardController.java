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

import com.example.ajoutayo.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("bus/boards")
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response){
        boardService.viewCount(id, request, response); // views ++
        BoardResponseDto board= boardService.getBoard(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_BOARD,board));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id){
        String nickname = memberService.getNicknameWithAuth();
        boardService.deleteBoard(id, nickname);

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.DELETE_BOARD));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable("id") Long id, @RequestBody BoardUpdateDto boardUpdateDto){
        BoardResponseDto board= boardService.updateBoard(id, boardUpdateDto);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.UPDATE_BOARD,board));
    }
    @PostMapping("/new")
    public ResponseEntity<?> createBoard(Authentication authentication, @RequestBody BoardCreateDto boardCreateDto) {
        Long boardId = boardService.saveBoard(boardCreateDto, authentication.getName());
        BoardResponseDto board= boardService.getBoard(boardId);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.CREATE_BOARD,board));

    }
    @GetMapping("")
    public ResponseEntity<?>  getAllBoards(String search) {
        List<Board> boardList = null;
        String response = null;
        if(search==null) {
            boardList = boardService.getAllBoards();
            response=ResponseMessage.GET_ALL_BOARD;

        }else{
            boardList = boardService.getBoardsByKeyWord(search);
            response=ResponseMessage.SEARCH_SUCCESS;
        }
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, response, boardList));
    }

}
