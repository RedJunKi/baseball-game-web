package jk.baseballgameweb.rank;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankRepository rankRepository;

    @PostMapping("/rank")
    public void recordRank(@RequestBody long attempts, String game) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            authentication.getName();
            Rank rank = new Rank();
            rank.setGame(GameType.valueOf(game));
            rank.setPoint(attempts);
            rankRepository.save(rank);
        }
    }
}
