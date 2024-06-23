package jk.baseballgameweb.auth;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByUsername(String username);

    List<Member> findAll();

    void deleteById(Long memberId);
}
