package christmas.model;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
    mushroomSoup("appetizer", "양송이수프", 6000, 0),
    tapas("appetizer", "타파스", 5500, 0),
    caesarSalad("appetizer", "시저샐러드", 8800, 0),
    tBoneSteak("main", "티본스테이크", 55000, 0),
    barbecuedRibs("main", "바비큐립", 54000, 0),
    seafoodPasta("main", "해산물파스타", 35000, 0),
    christmasPasta("main", "크리스마스파스타", 25000, 0),
    chocoCake("dessert", "초코케이크", 15000, 0),
    iceCream("dessert", "아이스크림", 5000, 0),
    zeroCoke("drink", "제로콜라", 3000, 0),
    redWine("drink", "레드와인", 60000, 0),
    champagne("drink", "샴페인", 25000, 0);

    private String menuType;
    private String menu;
    private int price;
    private int cnt;

    Menu(String menuType, String menu, int price, int cnt) {
        this.menuType = menuType;
        this.menu = menu;
        this.price = price;
        this.cnt = cnt;
    }

    public static List<String> getAllMenu() {
        List<String> allMenu = new ArrayList<>();
        for (Menu eachMenu : Menu.values()) {
            allMenu.add(eachMenu.menu);
        }
        return allMenu;
    }
}
