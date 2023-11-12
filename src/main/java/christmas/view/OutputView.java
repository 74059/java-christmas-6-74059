package christmas.view;

import java.io.Serializable;
import java.util.HashMap;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String START_EVENT_MESS = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFITS_PREVIEW_MESS_FRONT = "12월 ";
    private static final String EVENT_BENEFITS_PREVIEW_MESS_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_START_MESS = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_BEFFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String GIVE_SERVICE_MESS = "<증정 메뉴>";
    private static final String GIVE_CHAMPAGNE = "샴페인 1개";
    private static final String BENEFIT_LISTS = "<혜택 내역>";
    private static final String CHRISTMAS_D_DAY = "크리스마스 디데이 할인: -";
    private static final String BENEFIT = " 할인: -";
    private static final String ORDER_NUM_UNIT = "개";
    private static final String PRICE_UNIT = "원";
    private static final String NOTHING = "없음";

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

    public static void printTotalOrderPriceBeforeDiscount(int priceBeforeDiscount) {
        System.out.println(TOTAL_ORDER_PRICE_BEFFORE_DISCOUNT);
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println(decFormat.format(priceBeforeDiscount) + PRICE_UNIT);
        System.out.println();
    }

    public static void printCanGetChampagne(boolean canGetChampagne) {
        System.out.println(GIVE_SERVICE_MESS);
        if (canGetChampagne) {
            System.out.println(GIVE_CHAMPAGNE);
            System.out.println();
            return;
        }
        System.out.println(NOTHING);
        System.out.println();
    }

    public static void printNoBenefit() {
        System.out.println(BENEFIT_LISTS);
        System.out.println(NOTHING);
        System.out.println();
    }

    public static void printBenefit(int dDayBenefit, List<Serializable> weekDayEndBenefit) {
        System.out.println(BENEFIT_LISTS);
        printChristmasDDay(dDayBenefit);
        printWeekDayEnd(weekDayEndBenefit);
    }

    public static void printChristmasDDay(int christmasDDayB) {
        if (christmasDDayB != 0) {
            DecimalFormat decFormat = new DecimalFormat("###,###");
            System.out.println(CHRISTMAS_D_DAY + decFormat.format(christmasDDayB) + PRICE_UNIT);
        }
    }

    public static void printWeekDayEnd(List<Serializable> weekDayEndBenefit) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println(weekDayEndBenefit.get(0) + BENEFIT + decFormat.format(weekDayEndBenefit.get(1)) + PRICE_UNIT);
    }
}
