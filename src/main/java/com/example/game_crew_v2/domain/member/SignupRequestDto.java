package com.example.game_crew_v2.domain.member;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;
    private String userImg;

    public SignupRequestDto(String email, String nickname, String password, String userImg) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userImg = userImg;
    }
}
