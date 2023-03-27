package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.CreateBoardDto;
import com.example.ajoutayo.dto.response.BoardDto;

public interface BoardService {
    BoardDto getBoard(Long boardId);
    Long saveBoard(CreateBoardDto createBoardDto);
    List<Board> getAllBoards();

    int viewCount(Long boardId);
    void updateBoard(CreateBoardDto createBoardDto);
    void deleteBoard(Long boardId);


}
