package jk.baseballgameweb;

import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public static List<Integer> generate() {
        List<Integer> result = new ArrayList<>();

        int size = NumberConstants.NUMBER_GENERATE_SIZE.getValue();

        for (int i = 0; i < size; i++) {
            result.add(generateNum());
        }

        return result;
    }

    private static int generateNum() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }
}
