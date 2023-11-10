package christmas.controller;

import christmas.controller.ExceptionController;
import christmas.view.OutputView;
import christmas.view.InputView;

public class ChristmasController {
    public void run () {
        OutputView.printStartEvent();
        visitDate();
    }

    public void visitDate () {
        String visitDate =  InputView.readDate();
        ExceptionController.visitDateException(visitDate);
    }
}
