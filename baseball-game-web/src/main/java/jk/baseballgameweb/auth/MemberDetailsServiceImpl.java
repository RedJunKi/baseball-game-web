package jk.baseballgameweb.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {

    private final MemberService memberService;
    private final CustomAuthorityUtils customAuthorityUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> findMember = memberService.findByUsername(username);

        if (findMember.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        Member result = findMember.get();
        return new MemberDetails(result);
    }

    private final class MemberDetails extends Member implements UserDetails {

        MemberDetails(Member member) {
            setId(member.getId());
            setUsername(member.getUsername());
            setName(member.getName());
            setPassword(member.getPassword());
            setAuthority(member.getAuthority());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return customAuthorityUtils.createAuthorities(this.getAuthority());
        }

        @Override
        public String getUsername() {
            return super.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
