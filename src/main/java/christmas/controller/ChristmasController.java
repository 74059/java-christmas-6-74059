package christmas.controller;

import christmas.view.OutputView;
import christmas.view.InputView;

public class ChristmasController {
    public void run () {
        OutputView.printStartEvent();
        expectedVisitDate();
    }

    public void expectedVisitDate () {
        String visitDate =  InputView.readDate();
    }
}
