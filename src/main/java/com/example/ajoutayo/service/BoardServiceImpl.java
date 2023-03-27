package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.BoardResponseDto;
import com.example.ajoutayo.dto.CreateBoardDto;
import com.example.ajoutayo.infrastructure.BoardRepository;

//import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    @Transactional(readOnly = true)
    public BoardResponseDto getBoard(Long boardId) {
        /*
        Optional<Board> board = boardRepository.findById(boardId);

        if(board.isPresent()) {
            return board.get();
        }else{
            return board.orElse(null);
        }
        Board board = boardRepository.findById(boardId).get();
        return board;*/
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new BoardResponseDto(board);
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
    public int viewCount(int boardId) {
        return 0;
    }


    @Override
    public void updateBoard(CreateBoardDto createBoardDto) {

    }

    @Override
    public void deleteBoard(int boardId) {

    }

    ;
}