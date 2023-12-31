package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
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

    @DisplayName("평일에 구매할 경우 디저트 할인이 된다.")
    @Test
    void eventBenefitsWeekdayDessert() {
        int dates = 27;
        String weekday = "평일";
        List<Serializable> weekBenefits = EventBenefits.weekDayEndBenefit(dates);
        Assertions.assertThat(weekBenefits).contains(weekday);
    }

    @DisplayName("이벤트 달력에 별이 있으면 할인이 된다.")
    @Test
    void eventBenefitsStarInCalender() {
        int dates = 24;
        int answer = 1000;
        int starBenefits = EventBenefits.specialDiscount(dates);
        Assertions.assertThat(starBenefits).isEqualTo(answer);
    }

    @DisplayName("할인 받은 금액이 1만원 이상 2만원 미만일 경우 트리 뱃지를 받는다.")
    @Test
    void eventBenefitsBadge() {
        int benefits = 15000;
        String answer = "트리";
        String benefitsBadge = EventBenefits.decemberEventBadge(benefits);
        Assertions.assertThat(benefitsBadge).isEqualTo(answer);
    }
}
