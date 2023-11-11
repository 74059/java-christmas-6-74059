package christmas.view;

public class ExceptionView {
    private static final String INVALID_DATE_MESS = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER_MENU_MESS = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ORDER_ONLY_DRINK_MESS = "[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다른 메뉴와 함께 선택해주세요.";
    private static final String ORDER_OVER_20_MESS = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";

    public static void exceptionInvalidDateMess() {
        System.out.println(INVALID_DATE_MESS);
    }

    public static void exceptionInvalidOrderMenuMess() {
        System.out.println(INVALID_ORDER_MENU_MESS);
    }

    public static void exceptionOrderOnlyDrinkMess() {
        System.out.println(ORDER_ONLY_DRINK_MESS);
    }

    public static void exceptionOrderOver20Mess() {
        System.out.println(ORDER_OVER_20_MESS);
    }
}
