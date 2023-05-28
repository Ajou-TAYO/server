package com.example.ajoutayo.controller;

import com.example.ajoutayo.domain.Partnership;
import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.PartnershipResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.PartnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<?> getAllPartnership(){
        List<Partnership> partnershipList = partershipService.getAllPartnership();

        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_ALL_PARTNERSHIP, partnershipList));
    }

}
