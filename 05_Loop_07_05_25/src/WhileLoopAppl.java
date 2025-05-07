public class WhileLoopAppl {
    public static void main(String[] args) {
       // haharin();
        printStars(30,6);
        //double res = pow(2.2,2);
        //System.out.println("\n" + res);
        int res = sumDigits(6814729);
        System.out.println("\n" + res);
    }

    public static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static double pow(double x, int n) {
        double res =1;
        while (n > 0) {
            res = res * x;
            n--;
        }
        return res;
    }

    public  static void printStars(int n, int k) {
        int i = 1;
        int p = k-1;
        char c = ' ';
        while (i < n) {
            if(i % k != 0 && i % k == p) {
                System.out.print("*");
                p--;
            } else if (i % k != 0) {
                System.out.print("   ");
            } else {
                System.out.println(" ");
            }
            i++;
        }
    }


    public  static void haharin() {
        int counter = 10;
        while(counter >= 0) {
            System.out.println(counter);
            counter--;
        }
        System.out.println("Go!");
    }

}
