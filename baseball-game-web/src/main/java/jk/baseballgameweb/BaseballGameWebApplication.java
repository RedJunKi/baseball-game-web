package jk.baseballgameweb;

import jakarta.annotation.PostConstruct;
import jk.baseballgameweb.auth.MemberDto;
import jk.baseballgameweb.auth.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
			MemberDto member1 = new MemberDto("asd", "asdf", "asdf");
			MemberDto member2 = new MemberDto("asdf", "asdf", "asdf");
			MemberDto junki = new MemberDto("junki@naecco.com", "준기", "asdf");
			memberService.join(member1);
			memberService.join(member2);
			memberService.join(junki);

		}
	}
}
