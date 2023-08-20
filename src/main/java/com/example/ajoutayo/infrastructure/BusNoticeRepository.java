package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.BusNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusNoticeRepository extends JpaRepository<BusNotice, Long>{
    List<BusNotice> findAllByOrderByUrlDesc();

}
