//package jk.baseballgameweb.auth;
//
//import jakarta.persistence.EntityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MemberConfig {
//    private final MemberRepository memberRepository;
//
//    public MemberConfig(@Qualifier("springDataJpaMemberRepository") MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//
//}
