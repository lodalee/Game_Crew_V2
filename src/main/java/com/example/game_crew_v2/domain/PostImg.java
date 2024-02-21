package com.example.game_crew_v2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class PostImg {

    @Id @GeneratedValue
    @Column(name = "post_img_id")
    private Long id;

    private String postImg;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
