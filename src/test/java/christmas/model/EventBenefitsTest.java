package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EventBenefitsTest {
    @DisplayName("12만원 이상 구매했을 경우 샴페인 증정한다.")
    @Test
    void eventBenefitsChampagne() {
        int purchasePrice = 130000;
        int answer = 25000;
        int canCustomerGetChampagne = EventBenefits.canGetChampagne(purchasePrice);
        Assertions.assertThat(canCustomerGetChampagne).isEqualTo(answer);
    }
}
