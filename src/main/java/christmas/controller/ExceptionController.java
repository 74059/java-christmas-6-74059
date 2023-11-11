package christmas.controller;

import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.ExceptionView;

public class ExceptionController {
    public static boolean visitDateExceptionNotNum(String dates) {
        try {
            VisitDate.isTypeInt(dates);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
            return false;
        }
    }

    public static boolean visitDateExceptionNotInRange(int dates) {
        try {
            VisitDate.isRange1To31(dates);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
            return false;
        }
    }

    public static boolean orderMenuException(String orderMenu) {
        try {
            OrderMenu.menuPreprocessing(orderMenu);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidOrderMenuMess();
            return false;
        }
    }
}
