package jk.baseballgameweb.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = MemberNumberConstants.NAME_MIN, max = MemberNumberConstants.NAME_MAX, message = "아이디는 {min}글자 이상, {max}글자 이하로 작성해주세요.")
    private String loginId;
    @NotEmpty
    private String name;
    @Size(min = MemberNumberConstants.PASSWORD_MIN, max = MemberNumberConstants.PASSWORD_MAX, message = "비밀번호는 {min}글자 이상, {max}글자 이하로 작성해주세요.")
    private String password;

    public Member() {

    }

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
