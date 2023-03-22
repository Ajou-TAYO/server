package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.*;

public interface BoardService {
    List<Board> getAllBoards();
    void saveBoard(CreateBoardDto createBoardDto);
    int viewCount(Long boardId);
    Board getBoard(Long boardId);
    void updateBoard(CreateBoardDto createBoardDto);
    void deleteBoard(Long boardId);


}
