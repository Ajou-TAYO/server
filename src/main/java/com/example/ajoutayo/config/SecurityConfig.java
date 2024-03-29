package com.example.ajoutayo.config;

import com.example.ajoutayo.jwt.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CorsFilter corsFilter;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                // exception handling 할 때 우리가 만든 클래스를 추가
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                // 시큐리티는 기본적으로 세션을 사용
                // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
                .and()
                .authorizeRequests()
                .antMatchers("/my/login").permitAll()
                .antMatchers("/my/signup/**").permitAll()
                .antMatchers("/notices/new").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers(HttpMethod.DELETE,"/notices/{id}").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers(HttpMethod.PATCH,"/notices/{id}").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers(HttpMethod.POST,"/notices/{id}").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers("/notices/**").permitAll()
                .antMatchers("/campus/**").permitAll()
                .antMatchers("/bus/location/**").permitAll()
                .antMatchers("/bus/notices/**").permitAll()
                .antMatchers("/bin/**").permitAll()
                .antMatchers("/partnerships/**").permitAll()
                .anyRequest().authenticated()   // 나머지 API 는 전부 인증 필요

                .and()
                .logout()
                .logoutSuccessUrl("/my/logout")
                .invalidateHttpSession(true) //세션 날리기
                .logoutSuccessUrl("/my/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")

                // JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
                .and()
                .apply(new JwtSecurityConfig(jwtTokenProvider));

        return http.build();
    }
    public static String getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }
        return authentication.getName();
    }
}