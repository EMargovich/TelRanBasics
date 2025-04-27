public class FunctionAdvAppl {

    public static void main(String[] args) {
        double res = pi();
        printPi(res);

        double cl = circlelenght(3);
        System.out.println(cl);
    }

    private static double circlelenght(double radius) {
        return 2 * pi() * radius;
    }

    private static void printPi(double paramPi) {
        System.out.println(paramPi);
    }

    private static double pi() {
        return 3.1415926;
    }

    //res = max(50,6);
    //res = abs(-50);
    //res = min(50, 6);
}
