package com.example.ajoutayo.infrastructure;

import com.example.ajoutayo.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @EntityGraph(attributePaths = "auth")
    Optional<Member> findOneWithAuthByNickname(String nickname);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByMemberId(Long memberId);
    boolean existsByEmail(String email);

    @EntityGraph(attributePaths = "auth")
    Optional<Member> findOneWithAuthByEmail(String email);
}
