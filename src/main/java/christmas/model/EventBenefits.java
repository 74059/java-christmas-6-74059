package christmas.model;

import java.io.Serializable;
import java.util.List;

public class EventBenefits {
    public static int christmasDDayBenefit(int dates) {
        if ((25 - dates) >= 0) {
            return 1000 + (100 * (dates-1));
        }
        return 0;
    }

    public static List<Serializable> weekDayEndBenefit(int dates) {
        if ((dates % 7) == 1 || (dates % 7) == 2) {
            return List.of("주말", Menu.countSpecificMenuCnt("main") * 2023);
        }
        return List.of("평일", Menu.countSpecificMenuCnt("dessert") * 2023);
    }

    public static int specialDiscount(int dates) {
        if ((dates % 7) == 3 || dates == 25) {
            return 1000;
        }
        return 0;
    }
}
