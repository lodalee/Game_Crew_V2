package com.example.game_crew_v2.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {

    @NotBlank(message = "email 을 입력해 주세요.")
    private String email;

    @NotBlank(message = "password 를 입력해 주세요.")
    private String password;
}
