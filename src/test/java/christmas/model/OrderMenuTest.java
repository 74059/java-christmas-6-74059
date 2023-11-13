package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderMenuTest {
    List<String> NOTHING = List.of(new String[]{});
    String NOT_HYPHEN_IN_MENU = "해산물파스타2";
    List<String> SPLIT_HYPHEN_NOT_CONTAIN_2 = List.of(new String[]{"해산물파스타2"});
    String NOT_SATISFIED_CONDITION_NUM_PART = "0";
    String NOT_SATISFIED_CONDITION_MENU_PART = "메뉴에없음";
    List<String> CONTAIN_SAME_MENU = List.of(new String[]{"해산물파스타", "해산물파스타", "레드와인"});


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

    @DisplayName("읽어온 메뉴-개수 의 각 원소들에 - 이 없으면 예외가 발생한다.")
    @Test
    void createOrderMenuNotHyphen() {
        Assertions.assertThatThrownBy(() -> OrderMenu.isSplitValueInOrderMenu(NOT_HYPHEN_IN_MENU))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("읽어온 메뉴-개수 의 각 원소들을 - 로 split 한다.")
    @Test
    void orderMenuSplitHyphen() {
        String ORDER_MENU = "해산물파스타-2";
        List<String> SPLIT_WITH_HYPHEN = List.of(new String[]{"해산물파스타", "2"});
        List<String> splitHyphenOrderMenu = OrderMenu.splitHyphen(ORDER_MENU);
        Assertions.assertThat(splitHyphenOrderMenu).isEqualTo(SPLIT_WITH_HYPHEN);
    }

    @DisplayName("읽어온 메뉴-개수 의 각 원소들을 - 으로 split 시켰을 때, 원소가 두 개가 아니라면 예외가 발생한다.")
    @Test
    void createOrderMenuNotContain2() {
        Assertions.assertThatThrownBy(() -> OrderMenu.isContainSize2(SPLIT_HYPHEN_NOT_CONTAIN_2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴-개수 중, 개수 부분의 조건(1. int형 / 2. 1 이상)을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void createOrderMenuNumPartNotSatisfiedCondition() {
        Assertions.assertThatThrownBy(() -> OrderMenu.checkOrderNumPart(NOT_SATISFIED_CONDITION_NUM_PART))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴-개수 중, 메뉴 부분의 조건(1. 메뉴판에 없는 메뉴)을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void createOrderMenuPartNotSatisfiedCondition() {
        Assertions.assertThatThrownBy(() -> OrderMenu.checkOrderMenuPart(NOT_SATISFIED_CONDITION_MENU_PART))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 메뉴를 두 번 이상 작성했을 경우 예외가 발생한다.")
    @Test
    void createOrderMenuDifferentSizeAfterDuplicate() {
        Assertions.assertThatThrownBy(() -> OrderMenu.isChangeNumWhenMenuDuplicate(CONTAIN_SAME_MENU))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
