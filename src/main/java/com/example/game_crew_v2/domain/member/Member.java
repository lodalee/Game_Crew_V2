package com.example.game_crew_v2.domain.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String userImg;

    public Member(String email, String nickname, String password, String userImg) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userImg = userImg;
    }
}
