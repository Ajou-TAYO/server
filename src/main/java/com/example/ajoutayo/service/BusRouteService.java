package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.BusRoute;
import com.example.ajoutayo.dto.response.BusRouteResponseDto;
import com.example.ajoutayo.exceptions.BusRouteErrorCode;
import com.example.ajoutayo.exceptions.BusStopErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.infrastructure.BusRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BusRouteService {
    private final BusRouteRepository busRouteRepository;
    public BusRouteResponseDto getBusRoute(Long id) {
        BusRoute busRoute=busRouteRepository.findById(id).orElseThrow(()
                -> new CustomApiException(BusRouteErrorCode.BUS_ROUTE_NOT_EXIST));
        return new BusRouteResponseDto(busRoute);
    }

    public List<BusRoute> getAllRoute() {
        return busRouteRepository.findAll();
    }
}
