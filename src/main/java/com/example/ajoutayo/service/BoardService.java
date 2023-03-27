package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.*;

public interface BoardService {
    BoardResponseDto getBoard(Long boardId);
    Long saveBoard(CreateBoardDto createBoardDto);
    List<Board> getAllBoards();

    int viewCount(int boardId);
    void updateBoard(CreateBoardDto createBoardDto);
    void deleteBoard(int boardId);


}
