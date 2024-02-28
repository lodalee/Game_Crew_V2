package com.example.game_crew_v2.domain;

import com.example.game_crew_v2.domain.member.Member;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class JoinPlayer {

    @Id @GeneratedValue
    @Column(name = "join_player_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    //== 비즈니스 로직==//
}
