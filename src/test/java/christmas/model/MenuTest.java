package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

public class MenuTest {
    @DisplayName("메뉴 전 종류를 가져온다.")
    @Test
    void menuGetAllMenu() {
        List<String> allMenu = Menu.getAllMenu();
        Assertions.assertThat(allMenu).contains("양송이수프", "타파스", "시저샐러드", "티본스테이크",
                "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인");
    }

    @DisplayName("특정 menuType(drink)의 메뉴를 가져온다.")
    @EnumSource(value = Menu.class, names = {"zeroCoke", "redWine", "champagne"})
    @ParameterizedTest
    void menuGetSpecificMenuType(Menu menu) {
        List<Menu> drinkMenu = Menu.getMenuOfSpecificMenuType("drink");
        Assertions.assertThat(drinkMenu).contains(menu);
    }
}
