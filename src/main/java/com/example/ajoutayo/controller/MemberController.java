package com.example.ajoutayo.controller;

import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.request.LoginRequestDto;
import com.example.ajoutayo.dto.request.UpdateNicknameRequestDto;
import com.example.ajoutayo.dto.request.UpdatePasswordRequestDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.NicknameResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.dto.response.TokenDto;
import com.example.ajoutayo.exceptions.AuthErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.jwt.JwtAuthenticationFilter;
import com.example.ajoutayo.jwt.JwtTokenProvider;
import com.example.ajoutayo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@CrossOrigin(originPatterns = "http://localhost:8080, http://121.137.66.90:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/my")
public class MemberController {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDto.getEmail(), loginRequestDto.getPassword());
        try {
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            TokenDto tokenDto = jwtTokenProvider.generateToken(authentication);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtAuthenticationFilter.AUTHORIZATION_HEADER, tokenDto.getGrantType() + tokenDto.getAccessToken());

            return ResponseEntity.ok()
                    .headers(httpHeaders)
                    .body(DefaultResponse.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS));
        } catch (RuntimeException e) {
            if (e.getMessage().equals("활성화되지 않은 유저입니다."))
                throw new CustomApiException(AuthErrorCode.INACTIVE_USER);
            else
                throw e;
        }
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.LOGOUT_SUCCESS));
    }

    @GetMapping("/nickname/reset")
    public ResponseEntity<?> getNickname(){
        String nickname = memberService.getNicknameWithAuth();
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.GET_NICKNAME, nickname));
    }

    @PostMapping("/nickname/reset")
    public ResponseEntity<?> updateNickname(@Valid @RequestBody UpdateNicknameRequestDto updateNicknameRequestDto){
        memberService.updateNickname(updateNicknameRequestDto.getNickname());
        String nickname = memberService.getNicknameWithAuth();
        return  ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.UPDATE_NICKNAME, nickname));
    }

    @PostMapping("/password/reset")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody UpdatePasswordRequestDto updatePasswordRequestDto){
        if (!updatePasswordRequestDto.arePasswordsMatching()) {
            // checkPw와 newPw가 일치하지 않을 경우 예외 처리
            throw new CustomApiException(AuthErrorCode.NOT_MATCHING_PASSWORD);
        }
        memberService.updatePassword(updatePasswordRequestDto.getNewPw());
        return  ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.UPDATE_PASSWORD));
    }
}