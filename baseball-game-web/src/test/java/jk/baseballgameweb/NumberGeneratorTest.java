package jk.baseballgameweb;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("숫자 생성시 원하는 크기만큼 생성되는지 확인")
    void checkNumberRange(int numSize) {
        //given

        //when
        List<Integer> randomNums = NumberGenerator.generate(numSize);
        //then

        assertThat(randomNums.size()).isEqualTo(numSize);
    }

    @Test
    @DisplayName("0을 제외한 변수 생성 확인")
    void generateNum() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        int num = numberGenerator.generateNum();
        //then
        assertThat(num).isNotEqualTo(0);
    }
}