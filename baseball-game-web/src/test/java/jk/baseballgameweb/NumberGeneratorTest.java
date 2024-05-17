package jk.baseballgameweb;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void checkNumberRange() {
        //given
        List<Integer> randomNums = NumberGenerator.generate();

        //when
        int numSize = 3;
        //then

        assertThat(randomNums.size()).isEqualTo(numSize);
    }

}