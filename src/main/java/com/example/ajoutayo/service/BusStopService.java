package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.BusStop;
import com.example.ajoutayo.dto.response.BusStopResponseDto;
import com.example.ajoutayo.exceptions.BusStopErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.infrastructure.BusStopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BusStopService {
    private final BusStopRepository busStopRepository;

    public BusStopResponseDto getBusStop(Long id) {
        BusStop busStop= busStopRepository.findById(id).orElseThrow(()
            -> new CustomApiException(BusStopErrorCode.BUS_STOP_NOT_EXIST));
        return new BusStopResponseDto(busStop);
    }

    public List<BusStop> getAllBusStop() {
        return busStopRepository.findAll();
    }
}
