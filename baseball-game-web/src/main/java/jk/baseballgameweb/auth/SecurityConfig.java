package jk.baseballgameweb.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth.requestMatchers("/login", "/register", "/css/**", "/images/**", "/js/**", "/login/auth").permitAll()
                .anyRequest().authenticated());

        http.formLogin((form) -> form.loginPage("/login")
//                .loginProcessingUrl("/login/auth")
                .defaultSuccessUrl("/")
                .permitAll());

        http.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll());

        return http.build();
    }
}
