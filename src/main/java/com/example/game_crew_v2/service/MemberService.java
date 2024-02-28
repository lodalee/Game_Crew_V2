package com.example.game_crew_v2.service;

import com.example.game_crew_v2.domain.member.Member;
import com.example.game_crew_v2.domain.member.SignupRequestDto;
import com.example.game_crew_v2.global.exception.DuplicateException;
import com.example.game_crew_v2.global.message.ExceptionMessage;
import com.example.game_crew_v2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    /*
    회원가입
     */
    @Transactional
    public void join(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String userImg = requestDto.getUserImg();

        validationEmail(email);

        //등록
        Member member = new Member(email, nickname, password, userImg);
        memberRepository.save(member);
    }

    /*
    비즈니스 로직
     */
    //중복 이메일 검증
    public void validationEmail(String email) {
        Optional<Member> findEmail = memberRepository.findByEmail(email);
        if (findEmail.isPresent()){
            throw new DuplicateException(ExceptionMessage.DUPLICATE_EMAIL_EXISTS, HttpStatus.CONFLICT);
        }
    }

}
