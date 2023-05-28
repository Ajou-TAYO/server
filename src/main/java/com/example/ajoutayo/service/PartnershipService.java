package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.Partnership;
import com.example.ajoutayo.dto.response.PartnershipResponseDto;
import com.example.ajoutayo.exceptions.PartnershipErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.infrastructure.PartnershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PartnershipService {
    private final PartnershipRepository partnershipRepository;

    public List<Partnership> getAllPartnership() {
        return partnershipRepository.findAll();
    }

    public PartnershipResponseDto getPartnership(Long id) {
        Partnership partnership = partnershipRepository.findById(id).orElseThrow(()
            -> new CustomApiException(PartnershipErrorCode.PARTNERSHIP_NOT_EXIST));
        return new PartnershipResponseDto(partnership);
    }
}
