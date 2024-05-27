package jk.baseballgameweb.numberbaseball;

public class GameService {

    private String secretNumber;

    public GameService() {
        resetGame();
    }

    public GuessResult checkGuess(String guess) {
        int strikes = 0;
        int balls = 0;
        System.out.println("secretNumber = " + secretNumber);


        for (int i = 0; i < secretNumber.length(); i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                strikes++;
            } else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                balls++;
            }
        }

        return new GuessResult(strikes, balls);
    }

    public void resetGame() {
        secretNumber = NumberGenerator.generate();
    }
}

