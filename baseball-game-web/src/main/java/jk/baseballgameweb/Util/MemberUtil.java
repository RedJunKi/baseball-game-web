package jk.baseballgameweb.Util;

import jk.baseballgameweb.auth.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@RequiredArgsConstructor
public class MemberUtil {

    public static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
}
