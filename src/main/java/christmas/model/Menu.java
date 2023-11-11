package christmas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private final String menuType;
    private final String menu;
    private final int price;
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

    public static int countAllCnt() {
        int allCnt = 0;
        for (Menu eachMenu : Menu.values()) {
            allCnt += eachMenu.cnt;
        }
        return allCnt;
    }

    public static List<Menu> getMenuOfSpecificMenuType(String menuType) {
        List<Menu> specificMenuType = new ArrayList<>();
        for (Menu eachMenu : Menu.values()) {
            specificMenuType.add(checkMenuType(eachMenu, menuType));
        }
        specificMenuType.remove(null);
        return specificMenuType;
    }

    public static Menu checkMenuType(Menu eachMenu, String menuType) {
        if (Objects.equals(eachMenu.menuType, menuType)) {
            return eachMenu;
        }
        return null;
    }

    public static void updateOrder(String orderMenus) {
        Menu[] menuValue = Menu.values();
        List<String> order = List.of(orderMenus.split(","));
        for (String eachOrder : order) {
            List<String> menuAndNum = List.of(eachOrder.split("-"));
            countOrder(menuValue, menuAndNum);
        }
    }

    public static void countOrder(Menu[] menuValue, List<String> menuAndNum) {
        List<String> allMenu = getAllMenu();
        int menuIndex = allMenu.indexOf(menuAndNum.get(0));
        menuValue[menuIndex].cnt += Integer.parseInt(menuAndNum.get(1));
    }

    public static void isOrderOnlyDrink() {
        int allCnt = countAllCnt();
        int eachDrinkCnt = countSpecificMenuCnt("drink");
        if (allCnt != eachDrinkCnt) {
            throw new IllegalArgumentException();
        }
    }

    public static int countSpecificMenuCnt(String menuType) {
        List<Menu> drinkMenu = getMenuOfSpecificMenuType(menuType);
        int eachDrinkCnt = 0;
        for (Menu eachDrinkMenu:drinkMenu) {
            eachDrinkCnt += eachDrinkMenu.cnt;
        }
        return eachDrinkCnt;
    }
}
