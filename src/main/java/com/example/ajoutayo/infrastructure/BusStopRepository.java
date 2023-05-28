package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}
