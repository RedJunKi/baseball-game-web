package jk.baseballgameweb;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터 번호 생성 확인")
    void generateComputerNum() {
        //given
        Computer answer = new Computer(NumberGenerator.generate());
        //when

        //then
        assertThat(answer).isNotNull();
    }

    @Test
    @DisplayName("컴퓨터 번호 개수 확인")
    void collectNumSize() {
        //given
        Computer answer = new Computer(NumberGenerator.generate());
        //when
        List<Integer> answerNumbers = answer.getNumbers();
        //then
        assertThat(answer.size()).isEqualTo(NumberConstants.NUMBER_GENERATE_SIZE.getValue());
    }

}