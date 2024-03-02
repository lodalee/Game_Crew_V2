package com.example.game_crew_v2.domain.member.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupRequestDto {
    @NotBlank
    @Column(unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(unique = true)
    private String nickname;

    @NotBlank
    private String password;
    private String userImg;

    public SignupRequestDto() {
    }

    public SignupRequestDto(String email, String nickname, String password, String userImg) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userImg = userImg;
    }
}
