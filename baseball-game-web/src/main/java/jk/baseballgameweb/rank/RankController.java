package jk.baseballgameweb.rank;

import jk.baseballgameweb.Util.MemberUtil;
import jk.baseballgameweb.auth.Member;
import jk.baseballgameweb.auth.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RankController {

    private final RankRepository rankRepository;
    private final MemberService memberService;

//    @PostMapping("/rank")
    public void recordRank(@RequestBody int attempts, GameType game) {
        String username = MemberUtil.getUsername();
        Member member = memberService.getMember(username);
        Rank result = new Rank(member, game, attempts);
        rankRepository.save(result);
    }

    @GetMapping("/rank")
    public String getAllRanks(Model model) {
        List<Rank> ranks = rankRepository.findAll(Sort.by(Sort.Direction.ASC, "point"));
        List<RankDto> result = ranks.stream()
                .map(rank -> new RankDto(rank.getMember().getName(), rank.getGame().getDisplayName(), rank.getPoint()))
                .collect(Collectors.toList());
        model.addAttribute("ranks", result);
        return "rank/rank";
    }
}
