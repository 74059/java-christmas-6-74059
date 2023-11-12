package christmas.model;

import java.io.Serializable;
import java.util.List;

public class EventBenefits {
    public static int christmasDDayBenefit(int dates) {
        if ((25 - dates) >= 0) {
            return 3400 - (100 * dates);
        }
        return 0;
    }

    public static List<Serializable> weekDayEndBenefit(int dates) {
        if ((dates % 7) == 1 || (dates % 7) == 2) {
            return List.of("주말", Menu.countSpecificMenuCnt("main") * 2023);
        }
        return List.of("평일", Menu.countSpecificMenuCnt("dessert") * 2023);
    }
}
