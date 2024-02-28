package com.example.game_crew_v2.domain;

import com.example.game_crew_v2.domain.member.Member;
import com.example.game_crew_v2.Auditing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class RecordOfRatings extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Long evaluatedId; //평가 받은 member
    private Long evaluatorId; //평가한 member

    private int manner;
    private int participation;
    private int gamingSkill;
    private int enjoyable;
    private int sociability;

    private double totalRating;
}
