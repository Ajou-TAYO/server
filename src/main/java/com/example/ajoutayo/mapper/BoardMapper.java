package com.example.ajoutayo.mapper;

import java.util.List;
import com.example.ajoutayo.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
    List<BoardDto> getAllBoardList();

    int boardCount(); // 곧 생성할 BoardMapper.xml 첫번째 sql 문의 id 와 같음.
    BoardDto getBoard(Long boardId);

    void uploadBoard(BoardDto boardDto);
    void updateBoard(BoardDto boardDto);
    void deleteBoard(Long boardId);
    void viewCount(Long boardId);

}
