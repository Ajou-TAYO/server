package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.CampusAmenity;
import com.example.ajoutayo.dto.response.CampusAmenityResponseDto;
import com.example.ajoutayo.exceptions.CampusAmenityErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.infrastructure.CampusAmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class CampusAmenityService {
    private final CampusAmenityRepository amenityRepository;

    public CampusAmenityResponseDto getAmenity(Long id) {
        CampusAmenity amenity = amenityRepository.findById(id).orElseThrow(()
                -> new CustomApiException(CampusAmenityErrorCode.CAMPUS_AMENITY_NOT_EXIST));
        return new CampusAmenityResponseDto(amenity);
    }

    public List<CampusAmenity> getAllAmenities() { return amenityRepository.findAll(); }
}
