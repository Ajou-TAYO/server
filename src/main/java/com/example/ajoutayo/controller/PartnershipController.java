package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.LocationType;
import com.example.ajoutayo.domain.Partnership;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.PartnershipResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.PartnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:8080, http://121.137.66.90:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/partnerships")
public class PartnershipController {
    private final PartnershipService partershipService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getPartnership(@PathVariable("id") Long id){
        PartnershipResponseDto partnership = partershipService.getPartnership(id);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_PARTNERSHIP, partnership));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPartnerships(@RequestParam(required = false, name = "category") String categoryStr) {
        List<Partnership> partnershipList = partershipService.getAllPartnership();
        LocationType category = null;
        String response = ResponseMessage.GET_ALL_PARTNERSHIP;

        if (categoryStr != null) {
            try {
                category = LocationType.valueOf(categoryStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }

        final LocationType finalCategory = category;

        if (finalCategory != null) {
            partnershipList = partnershipList.stream()
                    .filter(p -> p.getCategory() == finalCategory)
                    .collect(Collectors.toList());
            response = ResponseMessage.GET_ALL_PARTNERSHIP_BY_CATEGORY;
        }

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, response, partnershipList));
    }


}
