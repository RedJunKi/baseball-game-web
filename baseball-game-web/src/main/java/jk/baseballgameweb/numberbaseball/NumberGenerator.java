package jk.baseballgameweb.numberbaseball;

import java.util.*;

public class NumberGenerator {

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> numbers = new HashSet<>();

        int size = NumberConstants.NUMBER_GENERATE_SIZE;

        makeNumbers(sb, numbers, size);

        return sb.toString();
    }

    private static void makeNumbers(StringBuilder sb, Set<Integer> numbers, int size) {
        while (numbers.size() < size) {
            int num = generateNum();
            if (!numbers.contains(num)) {
                numbers.add(num);
                sb.append(num);
            }
        }
    }

    private static int generateNum() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }
}
