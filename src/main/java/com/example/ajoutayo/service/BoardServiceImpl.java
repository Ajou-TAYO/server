package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.CreateBoardDto;
import com.example.ajoutayo.infrastructure.BoardRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public void saveBoard(CreateBoardDto createBoardDto) {

    }

    @Override
    public int viewCount(Long boardId) {
        return 0;
    }

    @Override
    public Board getBoard(Long boardId) {
        return null;
    }

    @Override
    public void updateBoard(CreateBoardDto createBoardDto) {

    }

    @Override
    public void deleteBoard(Long boardId) {

    }

    ;
}