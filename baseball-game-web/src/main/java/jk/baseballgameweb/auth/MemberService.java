package jk.baseballgameweb.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(Member member) {

        memberRepository.createMember(member);
    }

    public Member login(String id, String password) {
        return memberRepository.login(id, password);
    }
}
