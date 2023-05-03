package com.example.ajoutayo.controller;

import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.LocationService;
import com.example.ajoutayo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("bus/map")
public class LocationController {
    private final LocationService locationService;
    @GetMapping("")
    public ResponseEntity<?> getAllLocations(){
        List<?> locationList = locationService.getAllLocations();
        String response= ResponseMessage.GET_ALL_LOCATION;

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK,response,locationList));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getLocation(@PathVariable("id") Long id){
        String location = locationService.getLocation(id);
        String response= ResponseMessage.GET_ALL_LOCATION;

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK,response,location));
    }

}
