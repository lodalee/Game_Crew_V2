package com.example.game_crew_v2.api;

import com.example.game_crew_v2.domain.member.SignupRequestDto;
import com.example.game_crew_v2.global.message.MessageResponse;
import com.example.game_crew_v2.global.message.SuccessMessage;
import com.example.game_crew_v2.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public MessageResponse signup (@RequestBody @Valid SignupRequestDto requestDto) {
        memberService.join(requestDto);
        return new MessageResponse(SuccessMessage.SIGNUP_SUCCESSFUL);
    }
}
