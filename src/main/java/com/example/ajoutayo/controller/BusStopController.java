package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.BusStop;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.BusStopResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.BusStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus/location/stops")
public class BusStopController {
    private final BusStopService locationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBusStationLocation(@PathVariable("id") Long id){
        BusStopResponseDto location = locationService.getBusStop(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_STATION_LOCATION, location));
    }
    @GetMapping("")
    public ResponseEntity<?> getAllBusStationLocation(){
        List<BusStop> busStopList = locationService.getAllBusStop();

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_ALL_STATION_LOCATION, busStopList));
    }
}
