package jk.baseballgameweb.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public Long join(MemberDto member) {
        validateDuplicateMember(member.getLoginId());

        String encodedPassword = passwordEncoder.encode(member.getPassword());

        Member result = Member.builder()
                .loginId(member.getLoginId())
                .name(member.getName())
                .password(encodedPassword)
                .build();

        memberRepository.save(result);

        return result.getId();
    }

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId).filter(m -> passwordEncoder.matches(password, m.getPassword()))
                .orElse(null);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(String loginId) {
        Optional<Member> result = memberRepository.findByLoginId(loginId);
        result.ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
