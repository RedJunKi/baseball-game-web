package jk.baseballgameweb;

import java.util.Collections;
import java.util.List;

public record Player(List<Integer> numbers) {

    public List<Integer> answer() {
        return Collections.unmodifiableList(numbers);
    }

}
