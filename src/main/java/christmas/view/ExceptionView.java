package christmas.view;

public class ExceptionView {
    static final String INVALID_DATE_MESS = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void exceptionInvalidDateMess() {
        System.out.println(INVALID_DATE_MESS);
    }
}
