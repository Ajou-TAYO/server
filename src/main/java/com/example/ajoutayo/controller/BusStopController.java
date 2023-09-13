package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.BusStop;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.BusStopResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.BusStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:8080, http://121.137.66.90:5173")
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
