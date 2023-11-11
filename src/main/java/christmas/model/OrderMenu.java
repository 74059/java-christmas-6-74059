package christmas.model;

import java.util.List;
import java.util.Objects;

public class OrderMenu {
    public static void menuPreprocessing(String orderMenu) {
        String rmSpaceOrderMenu = removeSpace(orderMenu);
        List<String> splitForOrderNum = splitComma(rmSpaceOrderMenu);
    }

    public static void IsNumOfOrderMenuOver0(String orderMenu) {
        if (Objects.equals(orderMenu, "")) {
            throw new IllegalArgumentException();
        }
    }

    public static String removeSpace(String orderMenu) {
        IsNumOfOrderMenuOver0(orderMenu);
        return orderMenu.replace(" ", "");
    }

    public static List<String> splitComma(String orderMenu) {
        return List.of(orderMenu.split(","));
    }
}
