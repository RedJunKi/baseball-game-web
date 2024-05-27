package jk.baseballgameweb.auth;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, String> repository = new HashMap<>();

    public void createMember(Member member) {
        String id = member.getName();
        System.out.println("id = " + id);
        if (repository.containsKey(id)) {
            throw new IllegalArgumentException("중복된 아이디가 있습니다.");
        }
        repository.put(member.getName(), member.getPassword());
    }

    public Member login(String id, String password) {
        System.out.println("id = " + id);
        System.out.println("password = " + password);
        if (!repository.containsKey(id)) {
            throw new IllegalArgumentException("일치하는 아이디가 없습니다.");
        }

        if (!repository.get(id).equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new Member(id, password);
    }
}
