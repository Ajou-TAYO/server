package com.example.ajoutayo.controller;

import com.example.ajoutayo.dto.request.LoginRequestDto;
import com.example.ajoutayo.dto.response.TokenDto;
import com.example.ajoutayo.exceptions.AuthErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.jwt.JwtAuthenticationFilter;
import com.example.ajoutayo.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDto.getEmail(), loginRequestDto.getPassword());
        try {
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            TokenDto tokenDto = jwtTokenProvider.generateToken(authentication);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtAuthenticationFilter.AUTHORIZATION_HEADER, tokenDto.getGrantType()+tokenDto.getAccessToken());

            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("활성화되지 않은 유저입니다."))
                throw new CustomApiException(AuthErrorCode.INACTIVE_USER);
            else
                throw e;
        }
    }


}