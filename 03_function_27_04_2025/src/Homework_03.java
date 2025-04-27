public class Homework_03 {

    public static void main(String[] args) {
        double res;

        res = max(50,6);
        System.out.println(res);
        res = abs(-50);
        System.out.println(res);
        res = min(50,6);
        System.out.println(res);
    }

    private static double max(double a, double b) {
        return a > b ? a : b;
    }

    private static double min(double a, double b) {
        return a < b ? a : b;
    }

    private static double abs(double a) {
        return a > 0 ? a : -a;
    }
}
