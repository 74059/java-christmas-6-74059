package christmas.model;

public class Exceptions {
    public static void IsTypeInt(String dates) {
        try {
            Integer.parseInt(dates);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
