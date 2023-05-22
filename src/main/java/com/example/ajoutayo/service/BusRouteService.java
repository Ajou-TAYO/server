package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.BusRoute;
import com.example.ajoutayo.dto.response.BusRouteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BusRouteService {
    public BusRouteResponseDto getBusRoute(Long id) {
    }

    public List<BusRoute> getAllRoute() {
    }
}
