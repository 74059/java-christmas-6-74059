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

        isChangeNumWhenMenuDuplicate(partOfMenu);
    }

    public static void isNumOfOrderMenuOver0(String orderMenus) {
        if (Objects.equals(orderMenus, "")) {
            throw new IllegalArgumentException();
        }
    }

    public static String removeSpace(String orderMenus) {
        isNumOfOrderMenuOver0(orderMenus);
        return orderMenus.replace(" ", "");
    }

    public static List<String> splitComma(String orderMenus) {
        List<String> splitWithComma = List.of(orderMenus.split(","));
        isNothingInOrderMenu(splitWithComma);
        return splitWithComma;
    }

    public static void isNothingInOrderMenu(List<String> orderMenus) {
        if (orderMenus.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static String makeOrderMenuForInput(String orderMenu) {
        isSplitValueInOrderMenu(orderMenu);
        List<String> orderMenuSplit = splitHyphen(orderMenu);
        checkOrderNumPart(orderMenuSplit.get(1));
        checkOrderMenuPart(orderMenuSplit.get(0));
        return orderMenuSplit.get(0);
    }

    public static void isSplitValueInOrderMenu(String orderMenu) {
        if (!orderMenu.contains("-")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isContainSize2(List<String> orderMenu) {
        if (orderMenu.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> splitHyphen(String orderMenu) {
        List<String> orderMenuSplit = List.of(orderMenu.split("-"));
        isContainSize2(orderMenuSplit);
        return orderMenuSplit;
    }

    public static void checkOrderNumPart(String orderMenuNum) {
        isTypeInt(orderMenuNum);
        int menuNum = Integer.parseInt(orderMenuNum);
        isNumMoreThan1(menuNum);
    }

    public static void isTypeInt(String orderMenuNum) {
        try {
            Integer.parseInt(orderMenuNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNumMoreThan1(int orderMenuNum) {
        if (orderMenuNum < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkOrderMenuPart(String orderMenu) {
        List<String> allMenu = Menu.getAllMenu();
        isReadMenuInMenu(allMenu, orderMenu);
    }

    public static void isReadMenuInMenu(List<String> allMenu, String orderMenu) {
        if (!allMenu.contains(orderMenu)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isChangeNumWhenMenuDuplicate(List<String> orderMenu) {
        Set<String> dupOrderMenu = new HashSet<>(orderMenu);
        if (orderMenu.size() != dupOrderMenu.size()) {
            throw new IllegalArgumentException();
        }
    }
}
