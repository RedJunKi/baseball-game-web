package jk.baseballgameweb;

import jakarta.annotation.PostConstruct;
import jk.baseballgameweb.auth.Member;
import jk.baseballgameweb.auth.MemberDto;
import jk.baseballgameweb.auth.MemberService;
import jk.baseballgameweb.board.Board;
import jk.baseballgameweb.board.BoardDto;
import jk.baseballgameweb.board.BoardRepository;
import jk.baseballgameweb.board.BoardService;
import jk.baseballgameweb.rank.GameType;
import jk.baseballgameweb.rank.Rank;
import jk.baseballgameweb.rank.RankController;
import jk.baseballgameweb.rank.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class BaseballGameWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseballGameWebApplication.class, args);
	}

	@RequiredArgsConstructor
	@Component
	public static class InitClass {
		private final MemberService memberService;
		private final RankController rankController;
		private final RankRepository rankRepository;
		private final BoardService boardService;

		@PostConstruct
		public void initMember() {
			MemberDto member1 = new MemberDto("asd", "asdf", "asdf");
			MemberDto member2 = new MemberDto("asdf", "asdf", "asdf");
			MemberDto junki = new MemberDto("junki@naecco.com", "준기", "asdf");
			memberService.join(member1);
			memberService.join(member2);
			memberService.join(junki);
//			Member findMember = memberService.findByUsername("asdf").get();
//			Rank rank = new Rank(findMember, GameType.NUMBER_BASEBALL, 10L);
//			rankRepository.save(rank);
			BoardDto boardDto = new BoardDto("asdf", "123", "456");
			boardService.post(boardDto);
		}
	}
}
