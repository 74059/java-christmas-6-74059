package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderMenuTest {
    List<String> NOTHING = List.of(new String[]{});

    @DisplayName("읽어온 메뉴-개수 에 공백이 있으면 제거한다.")
    @Test
    void orderMenuRemoveSpace() {
        String SPACE_IN_ORDER_MENU = "해 산 물 파스타 -  2  ,  레 드  와 인 -   1  ";
        String ORDER_MENU = "해산물파스타-2,레드와인-1";
        String removeSpaceOrderMenu = OrderMenu.removeSpace(SPACE_IN_ORDER_MENU);
        Assertions.assertThat(removeSpaceOrderMenu).isEqualTo(ORDER_MENU);
    }

    @DisplayName("읽어온 메뉴-개수 를 , 을 기준으로 split 한다.")
    @Test
    void orderMenuSplitComma() {
        String ORDER_MENU = "해산물파스타-2,레드와인-1";
        List<String> SPLIT_WITH_COMMA = List.of(new String[]{"해산물파스타-2", "레드와인-1"});
        List<String> splitCommaOrderMenu = OrderMenu.splitComma(ORDER_MENU);
        Assertions.assertThat(splitCommaOrderMenu).isEqualTo(SPLIT_WITH_COMMA);
    }

    @DisplayName("읽어온 메뉴-개수 의 개수가 없다면 예외가 발생한다.")
    @Test
    void createOrderMenuNothing() {
        Assertions.assertThatThrownBy(() -> OrderMenu.isNothingInOrderMenu(NOTHING))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
