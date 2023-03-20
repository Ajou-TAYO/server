package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.model.dao.BoardMapper;
import com.example.ajoutayo.model.dto.BoardDto;
import org.springframework.transaction.annotation.Transactional;

public interface BoardService {
    public List<BoardDto> getAllBoardList();


    public void uploadBoard(BoardDto board);
}
