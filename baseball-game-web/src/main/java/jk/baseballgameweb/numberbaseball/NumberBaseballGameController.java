package jk.baseballgameweb.numberbaseball;


import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NumberBaseballGameController {

    private static final String GAME_SERVICE_SESSION_KEY = "gameService";

    @PostMapping("/guess")
    public GuessResult guessNumber(@RequestBody GuessRequest request, HttpSession session) {
        NumberBaseballGameService numberBaseballGameService = getGameService(session);
        return numberBaseballGameService.checkGuess(request.getGuess());
    }

    @PostMapping("/new-game")
    public void newGame(HttpSession session) {
        NumberBaseballGameService numberBaseballGameService = getGameService(session);
        numberBaseballGameService.resetGame();
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
