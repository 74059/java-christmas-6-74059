package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {
    private final String ORDER_MENU = "해산물파스타-2,레드와인-1";

    @DisplayName("읽어온 메뉴-개수 에 공백이 있으면 제거한다.")
    @Test
    void orderMenuRemoveSpace() {
        String SPACE_IN_ORDER_MENU = "해 산 물 파스타 -  2  ,  레 드  와 인 -   1  ";
        String removeSpaceOrderMenu = OrderMenu.removeSpace(SPACE_IN_ORDER_MENU);
        Assertions.assertThat(removeSpaceOrderMenu).isEqualTo(ORDER_MENU);
    }
}
