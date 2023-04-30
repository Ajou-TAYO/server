package com.example.ajoutayo.service;

import java.util.List;

import com.example.ajoutayo.domain.Board;
import com.example.ajoutayo.dto.request.BoardCreateDto;
import com.example.ajoutayo.dto.request.BoardUpdateDto;
import com.example.ajoutayo.dto.response.BoardResponseDto;
import com.example.ajoutayo.exceptions.BoardErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.infrastructure.BoardRepository;

import com.example.ajoutayo.infrastructure.MemberRepository;
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
    @Autowired
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public BoardResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new CustomApiException(BoardErrorCode.BOARD_NOT_EXIST));

        return new BoardResponseDto(board);
    }

    @Override
    @Transactional
    public void deleteBoard(Long boardId, String nickname) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new CustomApiException(BoardErrorCode.BOARD_NOT_EXIST));
        if(!board.getNickname().equals(nickname)){
            throw new CustomApiException(BoardErrorCode.NOT_MATCH_ROLE);
        }
        boardRepository.deleteById(boardId);
    }

    @Override
    @Transactional
    public Long saveBoard(BoardCreateDto boardCreateDto, String email) {
        String nickname = email.substring(0, email.indexOf("@"));

        Board board =  boardRepository.save(boardCreateDto.toEntity());
        board.saveNickname(nickname);

        return board.getBoardId();
    }
    @Override
    @Transactional
    public BoardResponseDto updateBoard(Long boardId, String nickname, BoardUpdateDto boardUpdateDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new CustomApiException(BoardErrorCode.BOARD_NOT_EXIST));
        if(!board.getNickname().equals(nickname)){
            throw new CustomApiException(BoardErrorCode.NOT_MATCH_ROLE);
        }
        board.update(boardUpdateDto.getTitle(), boardUpdateDto.getContent());
        return new BoardResponseDto(board);
    }
    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
    @Override
    @Transactional
    public List<Board> getBoardsByKeyWord(String keyword) {
        List<Board> boardsList = boardRepository.findByTitleContaining(keyword);
        return boardsList;
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
                Board board = boardRepository.findById(boardId).orElseThrow(()
                        -> new CustomApiException(BoardErrorCode.BOARD_NOT_EXIST));
                board.viewCountUp(board);

                oldCookie.setValue(oldCookie.getValue() + "_[" + boardId + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            Board board = boardRepository.findById(boardId).orElseThrow(()
                    -> new CustomApiException(BoardErrorCode.BOARD_NOT_EXIST));
            board.viewCountUp(board);

            Cookie newCookie = new Cookie("boardView", "[" + boardId + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }
}