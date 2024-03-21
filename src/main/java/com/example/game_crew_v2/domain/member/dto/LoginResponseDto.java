package com.example.game_crew_v2.domain.member.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String msg;
    private String token;

    public LoginResponseDto(String msg, String token){
        this.msg = msg;
        this.token = token;
    }
}
