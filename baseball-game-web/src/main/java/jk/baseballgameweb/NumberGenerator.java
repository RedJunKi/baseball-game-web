package jk.baseballgameweb;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> generate(int size) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(i);
        }
        return result;
    }
}
