package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.CampusAmenity;
import com.example.ajoutayo.domain.LocationType;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.CampusAmenityResponseDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.CampusAmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/campus")
public class CampusAmenityController {
    private final CampusAmenityService amenityService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getCampusAmenity(@PathVariable("id") Long id){
        CampusAmenityResponseDto amenity = amenityService.getAmenity(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_CAMPUS_AMENITY, amenity));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCampusAmenities(@RequestParam(required = false, name = "category") String categoryStr) {
        List<CampusAmenity> amenitiesList = amenityService.getAllAmenities();
        LocationType category = null;
        String response = ResponseMessage.GET_ALL_CAMPUS_AMENITIES;

        if (categoryStr != null) {
            try {
                category = LocationType.valueOf(categoryStr.toUpperCase());

            } catch (IllegalArgumentException e) {
                throw e;
            }
        }

        final LocationType finalCategory = category;

        if (finalCategory != null) {
            amenitiesList = amenitiesList.stream()
                    .filter(p -> p.getCategory() == finalCategory)
                    .collect(Collectors.toList());
            response = ResponseMessage.GET_ALL_CAMPUS_AMENITIES_BY_CATEGORY;
        }

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, response, amenitiesList));
    }
}
