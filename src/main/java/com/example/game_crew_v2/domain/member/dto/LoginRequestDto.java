package com.example.game_crew_v2.domain.member.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
