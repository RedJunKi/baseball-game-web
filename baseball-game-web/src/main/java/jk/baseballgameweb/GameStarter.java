package jk.baseballgameweb;

import java.util.List;

public class GameStarter {
    private Computer computer;

    public GameStarter() {
        this.computer = new Computer(NumberGenerator.generate());
    }

    public String checkGuess(String guess) {
        Parser.guess(guess);
    }
}
