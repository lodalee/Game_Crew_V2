package com.example.game_crew_v2.domain;

import com.example.game_crew_v2.domain.member.Member;
import com.example.game_crew_v2.domain.type.GameType;
import com.example.game_crew_v2.Auditing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Auditing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String content;
    private GameType gameType;

    private int totalNumber; //모집 인원 수
    private int currentNumber = 0; //현재 인원 수

    private int postViewCount = 0;

    //== 비즈니스 로직==//
    public void updatePost(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.totalNumber = post.getTotalNumber();
        this.gameType = post.getGameType();
    }

    //참여
    public void increaseNum(){
        currentNumber += 1;
    }

    //참여 취소
    public void decreaseNum() {
        currentNumber -= 1;

        if (this.currentNumber < 0){
            throw new IllegalStateException("참여 인원이 0보다 작을 수 없다.");
        }
    }

    public void increaseViewCount(){
        postViewCount += 1;
    }
}
