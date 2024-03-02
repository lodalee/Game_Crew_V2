package com.example.game_crew_v2.service;

import com.example.game_crew_v2.domain.member.Member;
import com.example.game_crew_v2.domain.member.dto.LoginRequestDto;
import com.example.game_crew_v2.domain.member.dto.SignupRequestDto;
import com.example.game_crew_v2.exception.DuplicateException;
import com.example.game_crew_v2.exception.InvalidInputException;
import com.example.game_crew_v2.exception.UserNotFoundException;
import com.example.game_crew_v2.jwt.JwtUtil;
import com.example.game_crew_v2.message.ExceptionMessage;
import com.example.game_crew_v2.repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    /*
    회원가입
     */
    @Transactional
    public void join(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();
        String nickname = requestDto.getNickname();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String userImg = requestDto.getUserImg();

        validationEmail(email);
        validationNickname(nickname);

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
            throw new DuplicateException(ExceptionMessage.DUPLICATE_EMAIL_EXISTS);
        }
    }

    //중복 닉네임 검증
    public void validationNickname(String nickname) {
        Optional<Member> findNickname = memberRepository.findByNickname(nickname);
        if (findNickname.isPresent()) {
            throw new DuplicateException(ExceptionMessage.DUPLICATE_NICKNAME_EXISTS);
        }
    }

    @Transactional
    public void login(LoginRequestDto requestDto, HttpServletResponse response) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        Member member = memberRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException()
        );

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new InvalidInputException();
        }

        String token = jwtUtil.creatToken(member.getEmail());
        jwtUtil.addJwtToCookie(token, response);
    }
}
