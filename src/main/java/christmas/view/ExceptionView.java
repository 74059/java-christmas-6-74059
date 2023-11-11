package christmas.view;

public class ExceptionView {
    private static final String INVALID_DATE_MESS = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER_MENU_MESS = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ORDER_ONLY_DRINK_MESS = "[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다른 메뉴와 함께 선택해주세요.";

    public static void exceptionInvalidDateMess() {
        System.out.println(INVALID_DATE_MESS);
    }

    public static void exceptionInvalidOrderMenuMess() {
        System.out.println(INVALID_ORDER_MENU_MESS);
    }

    public static void exceptionOrderOnlyDrinkMess() {
        System.out.println(ORDER_ONLY_DRINK_MESS);
    }
}
