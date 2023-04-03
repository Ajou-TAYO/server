package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;
import com.example.ajoutayo.infrastructure.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void viewCount(Long boardId, HttpServletRequest request, HttpServletResponse response) {
        Cookie oldCookie = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("boardView")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + boardId.toString() + "]")) {
                boardRepository.updateView(boardId);
                oldCookie.setValue(oldCookie.getValue() + "_[" + boardId + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            boardRepository.updateView(boardId);
            Cookie newCookie = new Cookie("boardView", "[" + boardId + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }

        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        board.viewCountUp(board);
    }
}