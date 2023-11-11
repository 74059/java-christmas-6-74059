package christmas.controller;

import christmas.view.ExceptionView;
import christmas.model.VisitDate;

public class ExceptionController {
    public static boolean visitDateExceptionNotNum(String dates) {
        try {
            VisitDate.IsTypeInt(dates);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
            return false;
        }
    }

    public static boolean visitDateExceptionNotInRange(int dates) {
        try {
            VisitDate.IsRange1To31(dates);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
            return false;
        }
    }
}
