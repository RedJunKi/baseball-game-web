package jk.baseballgameweb;

import java.util.Collections;
import java.util.List;

public class Player {
    private final List<Integer> guess;

    public Player(List<Integer> guess) {
        validNumberSize(guess);
        validNumberRange(guess);
        this.guess = guess;

    }

    private void validNumberRange(List<Integer> guess) {
        if (guess.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void validNumberSize(List<Integer> guess) {
        if (guess.size() != NumberConstants.NUMBER_GENERATE_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> answer() {
        return Collections.unmodifiableList(guess);
    }

}
