package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.dto.BoardDto;

public interface BoardService {
    public List<BoardDto> getAllBoardList();

    public void uploadBoard(BoardDto boardDto);
}
