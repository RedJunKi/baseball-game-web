package jk.baseballgameweb;

import jakarta.annotation.PostConstruct;
import jk.baseballgameweb.auth.Member;
import jk.baseballgameweb.auth.MemberRepository;
import jk.baseballgameweb.auth.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BaseballGameWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseballGameWebApplication.class, args);
	}

	@RequiredArgsConstructor
	@Component
	public static class InitClass {
		private final MemberService memberService;

		@PostConstruct
		public void initMember() {
			Member member1 = new Member("asd", "asdf", "asdf");
			Member member2 = new Member("asdf", "asdf", "asdf");
			memberService.join(member1);
			memberService.join(member2);
		}
	}
}
