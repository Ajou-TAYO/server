package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.*;

public interface BoardService {
    public List<Board> getAllBoards();
    public void saveBoard(CreateBoardDto createBoardDto);
    public int viewCount(Long boardId);
    public Board getBoard(Long boardId);
    public void updateBoard(CreateBoardDto createBoardDto);
    public void deleteBoard(Long boardId);


}
