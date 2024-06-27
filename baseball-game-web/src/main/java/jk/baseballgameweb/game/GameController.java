package jk.baseballgameweb.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @GetMapping("/hanoi")
    public String getHanoi() {
        return "game/hanoi";
    }

    @GetMapping("/number-baseball")
    public String getNumberBaseball() {
        return "game/number-baseball";
    }

    @GetMapping("/blackjack")
    public String getBlackjack() {
        return "game/blackjack";
    }
}
