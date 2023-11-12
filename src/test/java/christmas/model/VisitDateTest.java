package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class VisitDateTest {
    private final String DATE_NOT_NUM = "c";

    @DisplayName("읽어온 날짜 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createDateNotNumber() {
        Assertions.assertThatThrownBy(() -> VisitDate.isTypeInt(DATE_NOT_NUM))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
