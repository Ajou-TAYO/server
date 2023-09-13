package com.example.ajoutayo.controller;

import com.example.ajoutayo.dto.StatusCode;
import com.example.ajoutayo.dto.request.EmailRequestDto;
import com.example.ajoutayo.dto.request.SignupRequestDto;
import com.example.ajoutayo.dto.response.DefaultResponse;
import com.example.ajoutayo.dto.response.MemberResponseDto;
import com.example.ajoutayo.dto.response.ResponseMessage;
import com.example.ajoutayo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(originPatterns = "http://localhost:8080, http://121.137.66.90:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/my/signup")
public class AuthController {
    private final MemberService memberService;

    @PostMapping("/")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        memberService.verifyCode(signupRequestDto.getEmail(),signupRequestDto.getVerificationCode());
        MemberResponseDto memberInfo = memberService.signup(signupRequestDto);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.CREATED_USER, memberInfo));
    }
    @PostMapping("/email/request")
    public ResponseEntity<?> authEmail(@RequestBody @Valid EmailRequestDto emailDto) {
        memberService.authEmail(emailDto);
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.REQUEST_EMAIL_VERIFICATION));
    }

    @PostMapping("/email")
    public ResponseEntity<?> checkEmailDuplicate(@RequestBody @Valid EmailRequestDto emailDto) {
        boolean mail = memberService.checkEmailDuplicate(emailDto.getEmail());
        return ResponseEntity.ok(DefaultResponse.res(StatusCode.OK, ResponseMessage.VALID_EMAILE, mail));
    }
}
