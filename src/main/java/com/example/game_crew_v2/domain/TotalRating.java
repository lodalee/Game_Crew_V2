package com.example.game_crew_v2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TotalRating {

    @Id @GeneratedValue
    @Column(name = "total_rating_id")
    private Long id;

    @Column(nullable = false)
    private Long evaluatedId; // 평가 받은 사람

    private double totalManner;
    private double totalParticipation;
    private double totalGamingSkill;
    private double totalEnjoyable;
    private double totalSociability;
    private double totalRating;

    //==비즈니스 로직==//
    public TotalRating(Long evaluated_user, double totalManner, double totalParticipation, double totalGamingSkill,
                       double totalEnjoyable, double totalSociability, double totalRating) {
        this.evaluatedId = evaluated_user;
        this.totalManner = totalManner;
        this.totalParticipation = totalParticipation;
        this.totalGamingSkill = totalGamingSkill;
        this.totalEnjoyable = totalEnjoyable;
        this.totalSociability = totalSociability;
        this.totalRating = Math.round(totalRating * 2) / 2.0;;
    }

    public void setTotalManner(double totalManner) {
        this.totalManner = Math.round(totalManner * 2) / 2.0;;
    }

    public void setTotalParticipation(double totalParticipation) {
        this.totalParticipation = Math.round(totalParticipation * 2) / 2.0;;
    }

    public void setTotalGamingSkill(double totalGamingSkill) {
        this.totalGamingSkill = Math.round(totalGamingSkill * 2) / 2.0;;
    }

    public void setTotalEnjoyable(double totalEnjoyable) {
        this.totalEnjoyable = Math.round(totalEnjoyable * 2) / 2.0;;
    }

    public void setTotalSociability(double totalSociability) {
        this.totalSociability = Math.round(totalSociability * 2) / 2.0;;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = Math.round(totalRating * 2) / 2.0;;
    }

}
