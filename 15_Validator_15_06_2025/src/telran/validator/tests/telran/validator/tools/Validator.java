package telran.validator.tests.telran.validator.tools;

public class Validator {
    public static boolean checkCreditCard(String str) {
        String pattern = "\\d{8,19}";
        return str.matches(pattern);
    }

    public static boolean checkDateFormatEU (String str) {
        //DD.MM.YYYY
        String pattern = "(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}";
        return str.matches(pattern);
    }

    public static boolean checkDateFormatUS (String str) {
        //YYYY-MM-DD
        String pattern = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
        return str.matches(pattern);
    }
}
