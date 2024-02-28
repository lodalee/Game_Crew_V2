package com.example.game_crew_v2.service;

import com.example.game_crew_v2.domain.member.dto.SignupRequestDto;
import com.example.game_crew_v2.exception.DuplicateException;
import com.example.game_crew_v2.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입_이메일중복확인(){
        //given
        SignupRequestDto member = new SignupRequestDto("qwe123@email.com", "member1", "123qwe", null);
        SignupRequestDto member2 = new SignupRequestDto("qwe123@email.com", "member2", "123qwe", null);

        //when
        memberService.join(member);
        try {
            memberService.join(member2);
        } catch (DuplicateException e){
            return;
        }

        //then
        Assertions.fail("예외가 발생해야 한다.");
    }
}