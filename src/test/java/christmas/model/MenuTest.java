package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class MenuTest {
    @DisplayName("메뉴 전 종류를 가져온다.")
    @Test
    void menuGetAllMenu() {
        List<String> allMenu = Menu.getAllMenu();
        Assertions.assertThat(allMenu).contains("양송이수프", "타파스", "시저샐러드", "티본스테이크",
                "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인");
    }

    @DisplayName("선택한 메뉴가 내가 뽑고자하는 menuType(main)과 동일하다면 가져온다.")
    @EnumSource(value = Menu.class, names = {"tBoneSteak", "barbecuedRibs", "seafoodPasta", "christmasPasta"})
    @ParameterizedTest
    void menuGetOnlyMain(Menu menu) {
        String pickMenuType = "main";
        String eachMenu = String.valueOf(Menu.checkMenuType(menu, pickMenuType));
        Assertions.assertThat(eachMenu).contains(String.valueOf(menu));
    }

    @DisplayName("특정 menuType(drink)의 메뉴를 가져온다.")
    @EnumSource(value = Menu.class, names = {"zeroCoke", "redWine", "champagne"})
    @ParameterizedTest
    void menuGetSpecificMenuType(Menu menu) {
        List<Menu> drinkMenu = Menu.getMenuOfSpecificMenuType("drink");
        Assertions.assertThat(drinkMenu).contains(menu);
    }

    @DisplayName("주문한 메뉴에 drink만 있을 경우, 예외가 발생한다.")
    @ValueSource(strings = {"샴페인-2,레드와인-1", "제로콜라-3"})
    @ParameterizedTest
    void createMenuOnlyDrink(String orderMenu) {
        Menu.removeAllCnt();
        Menu.updateOrder(orderMenu);
        Assertions.assertThatThrownBy(() -> Menu.isOrderOnlyDrink())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
