package com.example.ajoutayo.controller;

import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.request.LoginRequestDto;
import com.example.ajoutayo.dto.request.SignupRequestDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.MemberResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.dto.response.TokenDto;
import com.example.ajoutayo.exceptions.AuthErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.jwt.JwtAuthenticationFilter;
import com.example.ajoutayo.jwt.JwtTokenProvider;
import com.example.ajoutayo.service.MemberService;
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
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        MemberResponseDto memberInfo = memberService.signup(signupRequestDto);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.CREATED_USER, memberInfo));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();
        TokenDto tokenDto = memberService.login(email, password);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, tokenDto));
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> findMemberInfoByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findMemberInfoByEmail(email));
    }
}