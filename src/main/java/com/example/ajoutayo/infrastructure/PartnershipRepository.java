package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.Partnership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnershipRepository extends JpaRepository<Partnership, Long>{
}