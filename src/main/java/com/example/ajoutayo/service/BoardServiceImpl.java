package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.response.BoardDto;
import com.example.ajoutayo.dto.request.CreateBoardDto;
import com.example.ajoutayo.infrastructure.BoardRepository;

//import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    @Autowired
    private final BoardRepository boardRepository;
    @Override
    @Transactional(readOnly = true)
    public BoardDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new BoardDto(board);
    }
    @Override
    @Transactional
    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
    @Override
    @Transactional
    public Long saveBoard(CreateBoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getBoardId();
    }
    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
    @Override
    public int viewCount(Long boardId) {
        return 0;
    }
    @Override
    public void updateBoard(CreateBoardDto createBoardDto) {

    }
}