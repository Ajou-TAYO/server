package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;
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
    public BoardResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new BoardResponseDto(board);
    }

    @Override
    @Transactional
    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    @Transactional
    public Long saveBoard(BoardCreateDto boardCreateDto) {
        return boardRepository.save(boardCreateDto.toEntity()).getBoardId();
    }
    @Override
    @Transactional
    public BoardResponseDto updateBoard(Long boardId, BoardUpdateDto boardUpdateDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        board.update(boardUpdateDto.getTitle(), boardUpdateDto.getContent());
        return new BoardResponseDto(board);
    }
    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    @Transactional
    public int viewCount(Long boardId) {
        return boardRepository.updateView(boardId);
    }
}