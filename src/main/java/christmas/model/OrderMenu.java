package christmas.model;

import java.util.List;
import java.util.Objects;

public class OrderMenu {
    public static void menuPreprocessing(String orderMenu) {
        String rmSpaceOrderMenu = removeSpace(orderMenu);
        List<String> splitForOrderNum = splitComma(rmSpaceOrderMenu);
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
}
