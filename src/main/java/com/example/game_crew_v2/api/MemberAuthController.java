package com.example.game_crew_v2.api;

import com.example.game_crew_v2.domain.member.dto.LoginRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class MemberAuthController {

    /*
    로그인
     */
    public void login(@RequestBody @Valid LoginRequestDto requestDto) {

    }
}
