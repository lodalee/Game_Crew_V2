package com.example.game_crew_v2.domain;

import com.example.game_crew_v2.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TotalRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private double totalManner;
    private double totalParticipation;
    private double totalGamingSkill;
    private double totalEnjoyable;
    private double totalSociability;
    private double totalRating;
}
