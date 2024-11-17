package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 당첨_번호_객체_생성_테스트1() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_객체_생성_테스트2() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_객체_생성_테스트3() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_객체_생성_테스트4() {
        List<Integer> winningNumbers = List.of(-1, 2, 3, 4, 5, 44);
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}