public class ForLoopAppl {
    public static void main(String[] args) {
       // haharin();
       // printStars(32,4);
      //  test();
        double res = pow(2,10);
        System.out.println(res);
        int res2 = sumDigits(6814729);
        System.out.println(res2);
    }

    private static int sumDigits(int num) {
        int res;
        for (res = 0; num != 0; num = num / 10) {
            res = res + num % 10;
        }
        return res;
    }

    private static double pow(double v, int p) {
        double res = 1;
        for(int i = 0; i < p; i++) {
            res = res * v;
        }
        return res;
    }

    private static void test() {
       for (int i = 0, k = 10; i != k; i++, k--) {
           System.out.println("i = " + i + " k = " + k);
       }
    }

    public static void haharin() {
        for(int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Go!");
    }

    public static void printStars(int numStars, int inRow) {
        for(int i = 1; i <= numStars; i++) {
            if (i % inRow != 0) {
                System.out.print("*");
            } else {
                System.out.println("*");
            }
        }
    }


}