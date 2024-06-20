package jk.baseballgameweb.auth;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String password;

    private List<String> authority;

    public Member() {
    }

    public Member(Long id, String username, String name, String password, List<String> authority) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.authority = authority;
    }
}
