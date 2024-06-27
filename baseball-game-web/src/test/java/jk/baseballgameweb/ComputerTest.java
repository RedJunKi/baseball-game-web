//package jk.baseballgameweb;
//
//import static org.assertj.core.api.Assertions.*;
//
//import java.util.List;
//import java.util.stream.Stream;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//class ComputerTest {
//
//    @Test
//    @DisplayName("컴퓨터 번호 생성 확인")
//    void generateComputerNum() {
//        //given
//        Computer answer = new Computer(NumberGenerator.generate());
//        //when
//
//        //then
//        assertThat(answer).isNotNull();
//    }
//
//    @Test
//    @DisplayName("컴퓨터 번호 개수 확인")
//    void collectNumSize() {
//        //given
//        Computer answer = new Computer(NumberGenerator.generate());
//        //when
//        List<Integer> answerNumbers = answer.answer();
//        //then
//        assertThat(answerNumbers.size()).isEqualTo(NumberConstants.NUMBER_GENERATE_SIZE.getValue());
//    }
//
//    @ParameterizedTest
//    @MethodSource("provideLists")
//    @DisplayName("컴퓨터 번호 일치 확인")
//    void collectNumbers(List<Integer> comAnswer, List<Integer> playerAnswer) {
//        //given
//        Computer computerAnswer = new Computer(comAnswer);
//        //when
//        List<Integer> answerNumbers = computerAnswer.answer();
//        //then
//        assertThat(answerNumbers).isEqualTo(playerAnswer);
//    }
//
//    private static Stream<Arguments> provideLists() {
//        return Stream.of(
//                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3)),
//                Arguments.of(List.of(6, 5, 1, 2, 3, 4), List.of(6, 5, 1, 2, 3, 4))
//        );
//    }
//
//}