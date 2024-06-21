package jk.baseballgameweb.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jk.baseballgameweb.auth.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;
    private String title;
    private String content;

    public Board() {

    }

    public Board(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }
}
