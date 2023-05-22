package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.BusRoute;
import com.example.ajoutayo.domain.BusStop;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.BusRouteResponseDto;
import com.example.ajoutayo.dto.response.BusStopResponseDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.BusRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus/location/routes")
public class BusRouteController {
    private final BusRouteService busRouteService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getBusRoute(@PathVariable("id") Long id){
        BusRouteResponseDto busRoute = busRouteService.getBusRoute(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_BUS_ROUTE, busRoute));
    }
    @GetMapping("")
    public ResponseEntity<?> getAllBusRoute(){
        List<BusRoute> busRouteList = busRouteService.getAllRoute();

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_ALL_BUS_ROUTE, busRouteList));
    }
}
