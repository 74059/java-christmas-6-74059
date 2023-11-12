package christmas.controller;

import christmas.model.EventBenefits;
import christmas.model.Menu;
import christmas.view.OutputView;
import christmas.view.InputView;

import java.io.Serializable;
import java.util.List;

public class ChristmasController {
    private int dates = -1;
    private int totalBenefitPrice = 0;
    private int givePresent = 0;

    public void run() {
        OutputView.printStartEvent();
        visitDate();
        orderMenu();
        OutputView.printEventBenefitsPreview(dates);
        showEventBenefits();
        predictPayAfterDiscount();
        OutputView.printDecemberEventBadge(EventBenefits.decemberEventBadge(totalBenefitPrice + givePresent));
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
            String readOrderMenu = InputView.readOrderMenu().replace(" ", "");
            if (!ExceptionController.orderMenuException(readOrderMenu)) {
                continue;
            }
            Menu.updateOrder(readOrderMenu);
            if (!ExceptionController.orderMenuOnlyDrinkException() || !ExceptionController.orderMenuOver20Exception()) {
                Menu.removeAllCnt();
                continue;
            }
            break;
        }
    }

    public void showEventBenefits() {
        OutputView.printOrderMenu(Menu.countOrderMenuNameAndNum());
        int totalOrderPriceBeforeDiscount = Menu.totalOrderPrice();
        OutputView.printTotalOrderPriceBeforeDiscount(totalOrderPriceBeforeDiscount);
        givePresent = EventBenefits.canGetChampagne(totalOrderPriceBeforeDiscount);
        OutputView.printCanGetChampagne(givePresent);
        BenefitLists(givePresent, totalOrderPriceBeforeDiscount);
        totalBenefit();
    }

    public void BenefitLists(int givePresent, int totalOrderPriceBeforeDiscount) {
        if (totalOrderPriceBeforeDiscount < 10000) {
            OutputView.printNoBenefit();
            return;
        }
        int christmasDDayBenefit = EventBenefits.christmasDDayBenefit(dates);
        List<Serializable> weekDayEndBenefit = EventBenefits.weekDayEndBenefit(dates);
        int specialDiscount = EventBenefits.specialDiscount(dates);
        OutputView.printBenefit(christmasDDayBenefit, weekDayEndBenefit, specialDiscount, givePresent);
        int weekDayEndBenefitPrice = (int) weekDayEndBenefit.get(1);
        totalBenefitPrice += (christmasDDayBenefit + weekDayEndBenefitPrice + specialDiscount);
    }

    public void totalBenefit() {
        OutputView.printTotalBenefitPrice(totalBenefitPrice + givePresent);
    }

    public void predictPayAfterDiscount() {
        int totalOrderPriceBeforeDiscount = Menu.totalOrderPrice();
        OutputView.printPredictPayAfterDiscount(totalOrderPriceBeforeDiscount - totalBenefitPrice);
    }
}
