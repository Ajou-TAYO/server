package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.Auth;
import com.example.ajoutayo.domain.Member;
import com.example.ajoutayo.dto.request.SignupRequestDto;
import com.example.ajoutayo.dto.response.MemberResponseDto;
import com.example.ajoutayo.dto.response.TokenDto;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.exceptions.MemberErrorCode;
import com.example.ajoutayo.infrastructure.MemberRepository;
import com.example.ajoutayo.jwt.JwtTokenProvider;
import com.example.ajoutayo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResponseDto signup(SignupRequestDto signupRequestDto) {
        if (memberRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new CustomApiException(MemberErrorCode.DUP_EMAIL);
        }

        Member member = Member.builder()
                .email(signupRequestDto.getEmail())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .auth(Auth.MEMBER)
                .build();

        memberRepository.save(member);

        return new MemberResponseDto(member);
    }

    public MemberResponseDto findMemberInfoById(Long memberId) {
        return memberRepository.findById(memberId)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    public MemberResponseDto findMemberInfoByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    public TokenDto login(String email, String password) throws BadCredentialsException {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        TokenDto tokenDto = jwtTokenProvider.generateToken(authentication);

        return tokenDto;
    }

}