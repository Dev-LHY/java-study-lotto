package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 돈_객체_생성_테스트() {
        Assertions.assertThatThrownBy(() -> new Money(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

}