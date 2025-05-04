public class SwitchCaseAppl {
    public static void main(String[] args) {

        int mode = 4;

//        System.out.println("Test 1");
//        fun1(mode);
//        System.out.println("Test 2");
//        fun2(mode);
//        System.out.println("Test 3");
//        fun3(mode);

        double res = calculator(4,6,6);
        System.out.println("Result = " + res);

    }


    private static double calculator(double a, double b, int oper) {
        double res = switch (oper) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> {
                System.out.println();
                    yield  a / b;
            }
            default -> {
                System.out.println("Wrong operation.");
                yield 0. / 0.;
            }
        };
        return res;
    }

    public static void fun1(int mode) {

        if (mode == 0) System.out.println("Stop");
        else if (mode == 1) System.out.println("Slow");
        else if (mode == 2) System.out.println("Medium");
        else if (mode == 3) System.out.println("Fast");
        else System.out.println("Wrong mode");
    }

    public static void fun2(int mode) {
        switch(mode) {
            case 0:
                System.out.println("Stop");
                break;
            case 1:
                System.out.println("Slow");
                break;
            case 2:
                System.out.println("Medium");
                break;
            case 3:
                System.out.println("Fast");
                break;
            default:
                System.out.println("Wrong mode");
        }
    }

    public static void fun3(int mode) {
        switch (mode) {
            case 0 -> System.out.println("stop");
            case 1 -> System.out.println("Slow");
            case 2 -> System.out.println("Medium");
            case 3 -> System.out.println("Fast");
            default -> System.out.println("Wrong mode");

        }
    }
}
