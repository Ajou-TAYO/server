package com.example.ajoutayo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePasswordRequestDto {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 30, message = "비밀번호를 8자 이상 30자 이하로 입력해주세요.")

    private String newPw;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 30, message = "비밀번호를 8자 이상 30자 이하로 입력해주세요.")

    private String checkPw;

    public boolean arePasswordsMatching() {
        return newPw != null && newPw.equals(checkPw);
    }
}
