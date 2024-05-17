package jk.baseballgameweb;

import java.util.Collections;
import java.util.List;

public record Computer(List<Integer> answer) {

    @Override
    public List<Integer> answer() {
        return Collections.unmodifiableList(answer);
    }
}
