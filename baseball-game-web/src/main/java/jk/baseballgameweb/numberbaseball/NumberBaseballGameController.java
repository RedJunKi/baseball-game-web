package jk.baseballgameweb.numberbaseball;


import jakarta.servlet.http.HttpSession;
import jk.baseballgameweb.rank.GameType;
import jk.baseballgameweb.rank.Rank;
import jk.baseballgameweb.rank.RankController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NumberBaseballGameController {

    private static final String GAME_SERVICE_SESSION_KEY = "gameService";
    private final RankController rankController;

    @PostMapping("/guess")
    public GuessResult guessNumber(@RequestBody GuessRequest request, HttpSession session) {
        NumberBaseballGameService numberBaseballGameService = getGameService(session);
        return numberBaseballGameService.checkGuess(request.getGuess());
    }

    @PostMapping("/new-game")
    public ResponseEntity<Void> newGame(@RequestBody(required = false) Map<String, Integer> body, HttpSession session) {
        if (!body.isEmpty()) {
            Integer attempts = body.get("attempts");

            if (attempts != null) {
                rankController.recordRank(attempts, GameType.NUMBER_BASEBALL);
            }
        }

        NumberBaseballGameService numberBaseballGameService = getGameService(session);
        numberBaseballGameService.resetGame();

        return ResponseEntity.ok().build();
    }

    private NumberBaseballGameService getGameService(HttpSession session) {
        NumberBaseballGameService numberBaseballGameService = (NumberBaseballGameService) session.getAttribute(GAME_SERVICE_SESSION_KEY);
        if (numberBaseballGameService == null) {
            numberBaseballGameService = new NumberBaseballGameService();
            session.setAttribute(GAME_SERVICE_SESSION_KEY, numberBaseballGameService);
        }
        return numberBaseballGameService;
    }
}

class GuessRequest {
    private String guess;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}

class GuessResult {
    private int strikes;
    private int balls;

    public GuessResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
