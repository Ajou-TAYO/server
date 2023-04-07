package com.example.ajoutayo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EmailRequestDto {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식을 입력해주세요.")
    @Pattern(regexp = ".+@ajou.ac.kr", message = "아주대학교 이메일을 입력해주세요.")
    private String email;
}