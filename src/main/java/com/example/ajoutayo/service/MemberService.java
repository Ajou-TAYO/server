package com.example.ajoutayo.service;

import com.example.ajoutayo.domain.Auth;
import com.example.ajoutayo.domain.Member;
import com.example.ajoutayo.dto.request.EmailRequestDto;
import com.example.ajoutayo.dto.request.SignupRequestDto;
import com.example.ajoutayo.dto.response.MemberResponseDto;
import com.example.ajoutayo.dto.response.TokenDto;
import com.example.ajoutayo.exceptions.AuthErrorCode;
import com.example.ajoutayo.exceptions.CommonErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.exceptions.MemberErrorCode;
import com.example.ajoutayo.infrastructure.MemberRepository;
import com.example.ajoutayo.jwt.JwtTokenProvider;
import com.example.ajoutayo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    JavaMailSender javaMailSender;
    private final RedisUtil redisUtil;

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


    public void authEmail(EmailRequestDto request) {
        // 임의의 authKey 생성
        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(888888) + 111111);// 범위 : 111111 ~ 999999

        // 이메일 발송
        sendAuthEmail(request.getEmail(), authKey);
    }

    private void sendAuthEmail(String email, String authKey) {

        String subject = "AjouTayo - Email Verification";
        String text = "<h2>AjouTayo  이메일 인증 코드</h2>"
                + "<p>이메일 인증 코드 : <strong>" + authKey
                + "</strong></p><p>인증 코드는 5분 후에 만료됩니다. 시간 내에 인증 부탁드립니다.</p>"
                + "<p>인증이 원활히 이루어지지 않을 시 다시 로그인을 시도해주세요.</p>";
        checkAjouEmail(email);
        try {

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text, true); // 포함된 텍스트가 HTML이라는 의미로 true.
            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new CustomApiException(AuthErrorCode.EMAIL_SEND_FAILED);
        }

        // 유효 시간(5분)동안 {email, authKey} 저장
        redisUtil.setDataExpire(email, authKey, 60 * 5L);
    }

    private void checkAjouEmail(String email) {
        int idx = email.indexOf("@");
        String domain = email.substring(idx + 1);
        if (!domain.equals("ajou.ac.kr")) {
            throw new CustomApiException(AuthErrorCode.NOT_AJOU_EMAIL);
        }
    }

    public void verifyCode(String key, String input) {
        String value = redisUtil.getData(key);
        System.out.println(input + " " + value);
        if (!input.equals(value)) {
            throw new CustomApiException(AuthErrorCode.WRONG_VERIFICATION_CODE);
        }
    }
}