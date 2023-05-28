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
    //public ResponseEntity<?> getAllPartnershipWithCategory(@RequestParam(required = false, name = "category") LocationType type){
    public ResponseEntity<?> getAllPartnerships(LocationType type){
        List<Partnership> partnershipList = partershipService.getAllPartnership();
        if(type!=null) {
            partnershipList = partnershipList.stream().filter(p -> p.getCategory().getTitle().equals(type.getTitle())).collect(Collectors.toList());
        }
            return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_ALL_PARTNERSHIP, partnershipList));
    }


}
