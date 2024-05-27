package jk.baseballgameweb.numberbaseball;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private static final String GAME_SERVICE_SESSION_KEY = "gameService";

    @PostMapping("/guess")
    public GuessResult guessNumber(@RequestBody GuessRequest request, HttpSession session) {
        GameService gameService = getGameService(session);
        return gameService.checkGuess(request.getGuess());
    }

    @PostMapping("/new-game")
    public void newGame(HttpSession session) {
        GameService gameService = getGameService(session);
        gameService.resetGame();
    }

    private GameService getGameService(HttpSession session) {
        GameService gameService = (GameService) session.getAttribute(GAME_SERVICE_SESSION_KEY);
        if (gameService == null) {
            gameService = new GameService();
            session.setAttribute(GAME_SERVICE_SESSION_KEY, gameService);
        }
        return gameService;
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
