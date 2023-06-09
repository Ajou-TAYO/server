package com.example.ajoutayo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginRequestDto {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식을 입력해주세요.")
    @Pattern(regexp = ".+@ajou.ac.kr", message = "아주대학교 이메일을 입력해주세요.")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 30)
    private String password;

}
