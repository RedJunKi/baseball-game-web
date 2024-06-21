package jk.baseballgameweb.auth;

import jakarta.persistence.*;
import jk.baseballgameweb.board.Board;
import jk.baseballgameweb.rank.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String password;

    private List<String> authority;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> board;

    public Member() {
    }
}
