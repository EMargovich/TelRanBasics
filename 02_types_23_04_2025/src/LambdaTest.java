public class LambdaTest {

    private static byte  count = 0;

    public static void main(String[] args) {
        function6();
        function1();
        function2();
    }

    private static void fPrint(String fName, FunInter fun) {
        String st = "\t";

        count++;
        System.out.println(st.repeat(count) + fName);
        if (fun != null) {
            fun.meth();
            System.out.println(st.repeat(count) + fName);
        }
        count--;
    }

    private static void function1 () {
        fPrint("Function1",LambdaTest::function6);
    }

    private static void function2 () {
        fPrint("Function2",LambdaTest::function4);
    }

    /* private static void function3 () {
    }*/

    private static void function4 () {
        fPrint("Function4",LambdaTest::function5);
    }

    private static void function5 () {
        fPrint("Function5",LambdaTest::function6);
    }

    private static void function6 () {
        fPrint("Function6",null);

    }
}

interface FunInter {
    void meth ();
}




