package jk.baseballgameweb.rank;

import jakarta.persistence.*;
import jk.baseballgameweb.auth.Member;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private GameType game;
    private int point;

    public Rank() {
    }

    public Rank(Member member, GameType game, int point) {
        this.member = member;
        this.game = game;
        this.point = point;
    }
}
