package christmas.view;

import java.util.HashMap;

public class OutputView {
    private static final String START_EVENT_MESS = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFITS_PREVIEW_MESS_FRONT = "12월 ";
    private static final String EVENT_BENEFITS_PREVIEW_MESS_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_START_MESS = "<주문 메뉴>";
    private static final String ORDER_NUM_UNIT = "개";

    public static void printStartEvent() {
        System.out.println(START_EVENT_MESS);
    }

    public static void printEventBenefitsPreview(int dates) {
        System.out.println(EVENT_BENEFITS_PREVIEW_MESS_FRONT + dates + EVENT_BENEFITS_PREVIEW_MESS_BACK);
        System.out.println();
    }

    public static void printOrderMenu(HashMap<String, Integer> orderMenuAndNum) {
        System.out.println(ORDER_MENU_START_MESS);
        for (String orderMenu : orderMenuAndNum.keySet()) {
            System.out.println(orderMenu + " " + orderMenuAndNum.get(orderMenu) + ORDER_NUM_UNIT);
        }
        System.out.println();
    }
}
