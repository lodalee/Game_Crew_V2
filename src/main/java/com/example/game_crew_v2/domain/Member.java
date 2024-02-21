package com.example.game_crew_v2.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "total_rating_id")
    private TotalRating totalRating;

    @Column(unique = true)
    @NotEmpty
    private String email;

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String password;
    private String userImg;

    public Member(String email, String nickname, String password, String userImg) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userImg = userImg;
    }
}
