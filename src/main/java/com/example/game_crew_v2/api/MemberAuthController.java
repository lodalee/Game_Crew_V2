package com.example.game_crew_v2.api;

import com.example.game_crew_v2.domain.member.dto.LoginRequestDto;
import com.example.game_crew_v2.message.SuccessMessage;
import com.example.game_crew_v2.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class MemberAuthController {

    private final MemberService memberService;

    /*
    로그인
     */
    @PostMapping("/member/login")
    public String login(@RequestBody @Valid LoginRequestDto requestDto, HttpServletResponse response) {

        memberService.login(requestDto, response);
        return SuccessMessage.LOGIN_SUCCESSFUL;
    }
}
