package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
