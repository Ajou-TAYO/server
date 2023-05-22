package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {


}
