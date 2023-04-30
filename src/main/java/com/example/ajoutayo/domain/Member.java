package com.example.ajoutayo.domain;

import com.example.ajoutayo.exceptions.BoardErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Getter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long memberId;

    @Column(updatable = false, unique = true, nullable = false, length = 20)
    private String email;

    @Column(unique = true, nullable = false, length = 18)
    private String nickname;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String auth;

    public void validateRole(Boolean isContaining, Auth... auth) {
        if (isContaining.equals(Arrays.stream(auth).noneMatch(role -> role.equals(this.auth)))) {
            throw new CustomApiException(BoardErrorCode.NOT_MATCH_ROLE);
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}