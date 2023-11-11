package christmas.model;

import java.util.List;
import java.util.Objects;

public class OrderMenu {
    public static void menuPreprocessing(String orderMenu) {
        String rmSpaceOrderMenu = removeSpace(orderMenu);
        List<String> splitForOrderNum = splitComma(rmSpaceOrderMenu);
        for (String orderMenuAndNum : splitForOrderNum) {
            makeOrderMenuForInput(orderMenuAndNum);
        }
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

    public static void makeOrderMenuForInput(String orderMenu) {
        IsSplitValueInOrderMenu(orderMenu);
        List<String> orderMenuSplit = splitHyphen(orderMenu);
        checkOrderNumPart(orderMenuSplit.get(1));
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
    }

    public static void IsTypeInt(String dates) {
        try {
            Integer.parseInt(dates);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
