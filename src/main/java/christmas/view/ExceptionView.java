package christmas.view;

public class ExceptionView {
    private static final String INVALID_DATE_MESS = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER_MENU_MESS = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void exceptionInvalidDateMess() {
        System.out.println(INVALID_DATE_MESS);
    }

    public static void exceptionInvalidOrderMenuMess() {
        System.out.println(INVALID_ORDER_MENU_MESS);
    }
}
