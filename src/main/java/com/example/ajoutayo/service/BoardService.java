package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
    BoardResponseDto getBoard(Long boardId);
    Long saveBoard(BoardCreateDto createBoardCreateDto, String userDetails);
    List<Board> getAllBoards();
    List<Board> getBoardsByKeyWord(String keyword);
    void viewCount(Long boardId, HttpServletRequest request, HttpServletResponse response);
    BoardResponseDto updateBoard(Long boardId, String nickname, BoardUpdateDto boardUpdateDto);
    void deleteBoard(Long boardId, String nickname);
}
