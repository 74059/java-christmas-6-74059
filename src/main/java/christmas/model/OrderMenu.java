package christmas.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OrderMenu {
    public static void menuPreprocessing(String orderMenu) {
        String rmSpaceOrderMenu = removeSpace(orderMenu);
        List<String> splitForOrderNum = splitComma(rmSpaceOrderMenu);

        List<String> partOfMenu = new ArrayList<>();
        for (String orderMenuAndNum : splitForOrderNum) {
            String customerOrder = makeOrderMenuForInput(orderMenuAndNum);
            partOfMenu.add(customerOrder);
        }

        IsChangeNumWhenMenuDuplicate(partOfMenu);
    }

    public static void IsNumOfOrderMenuOver0(String orderMenus) {
        if (Objects.equals(orderMenus, "")) {
            throw new IllegalArgumentException();
        }
    }

    public static String removeSpace(String orderMenus) {
        IsNumOfOrderMenuOver0(orderMenus);
        return orderMenus.replace(" ", "");
    }

    public static List<String> splitComma(String orderMenus) {
        return List.of(orderMenus.split(","));
    }

    public static String makeOrderMenuForInput(String orderMenu) {
        IsSplitValueInOrderMenu(orderMenu);
        List<String> orderMenuSplit = splitHyphen(orderMenu);
        checkOrderNumPart(orderMenuSplit.get(1));
        checkOrderMenuPart(orderMenuSplit.get(0));
        return orderMenuSplit.get(0);
    }

    public static void IsSplitValueInOrderMenu(String orderMenu) {
        if (!orderMenu.contains("-")) {
            throw new IllegalArgumentException();
        }
    }

    public static void IsContainSize2(List<String> orderMenu) {
        if (orderMenu.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> splitHyphen(String orderMenu) {
        List<String> orderMenuSplit = List.of(orderMenu.split("-"));
        IsContainSize2(orderMenuSplit);
        return orderMenuSplit;
    }

    public static void checkOrderNumPart(String orderMenuNum) {
        IsTypeInt(orderMenuNum);
        int menuNum = Integer.parseInt(orderMenuNum);
        IsNumMoreThan1(menuNum);
    }

    public static void IsTypeInt(String orderMenuNum) {
        try {
            Integer.parseInt(orderMenuNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void IsNumMoreThan1(int orderMenuNum) {
        if (orderMenuNum < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkOrderMenuPart(String orderMenu) {
        List<String> allMenu = Menu.getAllMenu();
        IsReadMenuInMenu(allMenu, orderMenu);
    }

    public static void IsReadMenuInMenu(List<String> allMenu, String orderMenu) {
        if (!allMenu.contains(orderMenu)) {
            throw new IllegalArgumentException();
        }
    }

    public static void IsChangeNumWhenMenuDuplicate(List<String> orderMenu) {
        Set<String> dupOrderMenu = new HashSet<>(orderMenu);
        if (orderMenu.size() != dupOrderMenu.size()) {
            throw new IllegalArgumentException();
        }
    }
}
