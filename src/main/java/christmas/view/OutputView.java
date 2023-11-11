package christmas.view;

public class OutputView {
    private static final String START_EVENT_MESS = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFITS_PREVIEW_MESS_FRONT = "12월 ";
    private static final String EVENT_BENEFITS_PREVIEW_MESS_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public static void printStartEvent() {
        System.out.println(START_EVENT_MESS);
    }

    public static void printEventBenefitsPreview(int dates) {
        System.out.println(EVENT_BENEFITS_PREVIEW_MESS_FRONT + dates + EVENT_BENEFITS_PREVIEW_MESS_BACK);
        System.out.println();
    }
}
