package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;

public interface BoardService {
    BoardResponseDto getBoard(Long boardId);
    Long saveBoard(BoardCreateDto createBoardCreateDto);
    List<Board> getAllBoards();
    int viewCount(Long boardId);
    BoardResponseDto updateBoard(Long boardId, BoardUpdateDto boardUpdateDto);
    void deleteBoard(Long boardId);


}
