package com.example.ajoutayo.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ajoutayo.domain.SiteUser;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
	Optional<SiteUser> findByEmail(String email);

}
