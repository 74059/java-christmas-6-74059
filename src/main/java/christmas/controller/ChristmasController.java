package christmas.controller;

import christmas.view.OutputView;
import christmas.view.InputView;

public class ChristmasController {
    private int dates = -1;

    public void run() {
        OutputView.printStartEvent();
        visitDate();
        orderMenu();
    }

    public void visitDate() {
        while (dates == -1) {
            String visitDate = InputView.readDate();
            if (!ExceptionController.visitDateExceptionNotNum(visitDate)) {
                continue;
            }

            int dates = Integer.parseInt(visitDate);
            if (!ExceptionController.visitDateExceptionNotInRange(dates)) {
                continue;
            }
            this.dates = dates;
        }
    }

    public void orderMenu() {
        while (true) {
            String orderMenu = InputView.readOrderMenu();
            if (!ExceptionController.orderMenuException(orderMenu)) {
                continue;
            }
            break;
        }
    }
}
