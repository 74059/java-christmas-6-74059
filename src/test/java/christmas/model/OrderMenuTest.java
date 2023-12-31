package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

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
    @ValueSource(strings = {"해산물파스타-2,레드와인-1"})
    @ParameterizedTest
    void orderMenuSplitComma(String orderMenuNum) {
        List<String> SPLIT_WITH_COMMA = List.of(new String[]{"해산물파스타-2", "레드와인-1"});
        List<String> splitCommaOrderMenu = OrderMenu.splitComma(orderMenuNum);
        Assertions.assertThat(splitCommaOrderMenu).isEqualTo(SPLIT_WITH_COMMA);
    }

    @DisplayName("읽어온 메뉴-개수 의 개수가 없다면 예외가 발생한다.")
    @Test
    void createOrderMenuNothing() {
        Assertions.assertThatThrownBy(() -> OrderMenu.isNothingInOrderMenu(NOTHING))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("읽어온 메뉴-개수 의 각 원소들에 - 이 없으면 예외가 발생한다.")
    @ValueSource(strings = {"해산물파스타2", "레드와인"})
    @ParameterizedTest
    void createOrderMenuNotHyphen(String menuNum) {
        Assertions.assertThatThrownBy(() -> OrderMenu.isSplitValueInOrderMenu(menuNum))
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
    @MethodSource("generateNOTContain2")
    @ParameterizedTest
    void createOrderMenuNotContain2(List<String> splitHyphenNotContain2) {
        Assertions.assertThatThrownBy(() -> OrderMenu.isContainSize2(splitHyphenNotContain2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateNOTContain2() {
        return Stream.of(
                Arguments.of(Arrays.asList("해산물파스타2")),
                Arguments.of(Arrays.asList("해산물파스타", "2", "1"))
        );
    }

    @DisplayName("메뉴-개수 중, 개수 부분의 조건(1. int형 / 2. 1 이상)을 만족하지 않는다면 예외가 발생한다.")
    @ValueSource(strings = {"ddd", "0", "-1"})
    @ParameterizedTest
    void createOrderMenuNumPartNotSatisfiedCondition(String notSatisfiedCondition) {
        Assertions.assertThatThrownBy(() -> OrderMenu.checkOrderNumPart(notSatisfiedCondition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴-개수 중, 메뉴 부분의 조건(1. 메뉴판에 없는 메뉴)을 만족하지 않는다면 예외가 발생한다.")
    @ValueSource(strings = {"메뉴에없음", "명란파스타", "아이수크림"})
    @ParameterizedTest
    void createOrderMenuPartNotSatisfiedCondition(String notSatisfiedCondition) {
        Assertions.assertThatThrownBy(() -> OrderMenu.checkOrderMenuPart(notSatisfiedCondition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 메뉴를 두 번 이상 작성했을 경우 예외가 발생한다.")
    @MethodSource("generateSameMENUData")
    @ParameterizedTest
    void createOrderMenuDifferentSizeAfterDuplicate(List<String> containSameMenu) {
        Assertions.assertThatThrownBy(() -> OrderMenu.isChangeNumWhenMenuDuplicate(containSameMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateSameMENUData() {
        return Stream.of(
                Arguments.of(Arrays.asList("해산물파스타", "해산물파스타", "레드와인")),
                Arguments.of(Arrays.asList("제로콜라", "초코케이크", "제로콜라"))
        );
    }
}
