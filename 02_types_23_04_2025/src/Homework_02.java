public class Homework_02 {
    public static void main(String[] args) {
        function6();
        function1();
        function2();
    }

    private static void function1() {
        System.out.println("Function 1");
        function4();
    }

    private static void function2() {
        System.out.println("Function 2");
        function6();
    }

    private static void function3() {
        System.out.println("Function 3");
    }

    private static void function4() {
        System.out.println("Function 4");
        function5();
    }

    private static void function5() {
        System.out.println("Function 5");
        function6();
    }

    private static void function6() {
        System.out.println("Function 6");
    }

}
