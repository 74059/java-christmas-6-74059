package christmas.model;

public class VisitDate {
    public static void isTypeInt(String dates) {
        try {
            Integer.parseInt(dates);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRange1To31(int dates) {
        if (!(dates >= 1 && dates <= 31)) {
            throw new IllegalArgumentException();
        }
    }
}
