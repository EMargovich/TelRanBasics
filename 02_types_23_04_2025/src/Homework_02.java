public class Homework_02 {

    private static byte count = 0;
    static String st = "\t";

    public static void main(String[] args) {

        System.out.println("main");
        function6();
        System.out.println("main");
        function1();
        System.out.println("main");
        function2();
        System.out.println("main");
    }

    private static void function1() {
        count++;
        System.out.println(st.repeat(count) + "Function 1");
        function4();
        System.out.println(st.repeat(count) + "Function 1");
        count--;
    }

    private static void function2() {
        count++;
        System.out.println(st.repeat(count) + "Function 2");
        function6();
        System.out.println(st.repeat(count) + "Function 2");
        count--;
    }

    private static void function3() {
        System.out.println("Function 3");
    }

    private static void function4() {
        count++;
        System.out.println(st.repeat(count) + "Function 4");
        function5();
        System.out.println(st.repeat(count) + "Function 4");
        count--;
    }

    private static void function5() {
        count++;
        System.out.println(st.repeat(count) + "Function 5");
        function6();
        System.out.println(st.repeat(count) + "Function 5");
        count--;
    }

    private static void function6() {
        count++;
        System.out.println(st.repeat(count) + "Function 6");
        count--;
    }

}
