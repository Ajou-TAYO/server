package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying
    @Query("update Board b set b.count = b.count + 1 where b.id = :id")
    int updateView(Long id);
}
