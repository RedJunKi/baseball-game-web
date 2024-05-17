package jk.baseballgameweb;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

class NumberGeneratorTest {

    @RepeatedTest(5)
    @DisplayName("숫자 생성시 원하는 크기만큼 생성되는지 확인")
    void checkNumberRange() {
        //given
        int numSize = NumberConstants.NUMBER_GENERATE_SIZE.getValue();
        //when
        List<Integer> randomNums = NumberGenerator.generate();
        //then

        assertThat(randomNums.size()).isEqualTo(numSize);
    }

    // private 메서드로 변환됨
//    @RepeatedTest(100)
//    @DisplayName("0을 제외한 변수 생성 확인")
//    void generateNum() {
//        //given
//        //when
//        int num = NumberGenerator.generateNum();
//        //then
//        assertThat(num).isGreaterThan(0).isLessThan(10);
//    }
}