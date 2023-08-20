package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByTitleContaining(String keyword);
    Optional<Notice> findTopByOrderByUpdatedAtDesc();
}
