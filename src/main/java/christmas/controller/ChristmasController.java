package christmas.controller;

import christmas.model.Menu;
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
        String readOrderMenu;
        while (true) {
            readOrderMenu = InputView.readOrderMenu();
            if (!ExceptionController.orderMenuException(readOrderMenu)) {
                continue;
            }
            Menu.updateOrder(readOrderMenu);
            if (!ExceptionController.orderMenuOnlyDrinkException()) {
                continue;
            }
            break;
        }
    }
}
