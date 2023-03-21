package com.example.ajoutayo.service;

import java.util.List;
import com.example.ajoutayo.mapper.BoardMapper;
import com.example.ajoutayo.dto.BoardDto;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> getAllBoardList() {
        return boardMapper.getAllBoardList();
    }

    @Override
    public void uploadBoard(BoardDto boardDto) {
        boardMapper.uploadBoard(boardDto);
    }
}