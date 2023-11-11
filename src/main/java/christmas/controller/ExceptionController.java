package christmas.controller;

import christmas.view.ExceptionView;
import christmas.model.Exceptions;

public class ExceptionController {
    public static boolean visitDateExceptionNotNum(String dates) {
        try {
            Exceptions.IsTypeInt(dates);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
            return false;
        }
    }

    public static boolean visitDateExceptionNotInRange(int dates) {
        try {
            Exceptions.IsRange1To31(dates);
            return true;
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
            return false;
        }
    }
}
