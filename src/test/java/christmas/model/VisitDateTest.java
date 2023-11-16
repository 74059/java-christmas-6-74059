package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class VisitDateTest {
    private final String DATE_NOT_NUM = "c";
    private final int DATE_NOT_IN_RANGE = 32;

    @DisplayName("읽어온 날짜 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createDateNotNumber() {
        Assertions.assertThatThrownBy(() -> VisitDate.isTypeInt(DATE_NOT_NUM))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("읽어온 날짜 값이 1 ~ 31 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void createDateOverRange() {
        Assertions.assertThatThrownBy(() -> VisitDate.isRange1To31(DATE_NOT_IN_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
