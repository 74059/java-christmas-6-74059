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

    @DisplayName("25일 이전에 구매할 경우, 크리스마스 디데이 할인이 된다.")
    @Test
    void eventBenefitsChristmasDDayBefore() {
        int dates = 24;
        int answer = 3300;
        int canCustomerGetChristmasDDayBenefit = EventBenefits.christmasDDayBenefit(dates);
        Assertions.assertThat(canCustomerGetChristmasDDayBenefit).isEqualTo(answer);
    }

    @DisplayName("25일 이후에 구매할 경우, 크리스마스 디데이 할인이 되지 않는다.")
    @Test
    void eventBenefitsChristmasDDayAfter() {
        int dates = 27;
        int answer = 0;
        int canCustomerGetChristmasDDayBenefit = EventBenefits.christmasDDayBenefit(dates);
        Assertions.assertThat(canCustomerGetChristmasDDayBenefit).isEqualTo(answer);
    }
}
