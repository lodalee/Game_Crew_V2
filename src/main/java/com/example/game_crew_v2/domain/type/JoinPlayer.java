package com.example.game_crew_v2.domain.type;

import com.example.game_crew_v2.domain.Member;
import com.example.game_crew_v2.domain.Post;
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

    private Boolean isAccepted = false; //참여 여부

    //== 비즈니스 로직==//
    public void updateAccepted() {
        this.isAccepted = !isAccepted;
    }
}
