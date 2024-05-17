package jk.baseballgameweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public static List<Integer> generate(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(generateNum());
        }
        return result;
    }

    private static int generateNum() {
        Random random = new Random();
        int result = random.nextInt(8) + 1;
        System.out.println("result = " + result);
        return result;
    }
}
