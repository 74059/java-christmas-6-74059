package christmas.model;

import java.util.List;

public class ReservationRestaurant {
    public static void menuPreprocessing(String orderMenu) {
        String rmSpaceOrderMenu = removeSpace(orderMenu);
        List<String> splitForOrderNum = splitComma(rmSpaceOrderMenu);
    }

    public static String removeSpace(String orderMenu) {
        return orderMenu.replace(" ", "");
    }

    public static List<String> splitComma(String orderMenu) {
        return List.of(orderMenu.split(","));
    }
}
