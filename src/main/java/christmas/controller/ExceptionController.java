package christmas.controller;

import christmas.view.ExceptionView;
import christmas.model.Exceptions;

public class ExceptionController {
    public static void visitDateException(String dates) {
        try {
            Exceptions.IsTypeInt(dates);
        } catch (IllegalArgumentException e) {
            ExceptionView.exceptionInvalidDateMess();
        }
    }
}
