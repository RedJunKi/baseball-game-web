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
    private final CustomAuthorityUtils authorityUtils;


    public Long join(MemberDto member) {
        validateDuplicateMember(member.getUsername());

        String encodedPassword = passwordEncoder.encode(member.getPassword());

        Member result = Member.builder()
                .username(member.getUsername())
                .name(member.getName())
                .password(encodedPassword)
                .authority(authorityUtils.createRoles(member.getUsername()))
                .build();

        memberRepository.save(result);

        return result.getId();
    }

    public Member login(String username, String password) {
        return memberRepository.findByUsername(username).filter(m -> passwordEncoder.matches(password, m.getPassword()))
                .orElse(null);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    private void validateDuplicateMember(String username) {
        Optional<Member> result = memberRepository.findByUsername(username);
        result.ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
