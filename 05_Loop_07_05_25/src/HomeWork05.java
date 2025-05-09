public class HomeWork05 {
    public static void main(String[] args) {

        int res = countDigits(0);
        System.out.println("Count digits = " + res);

        luckyNumber(121212);
        luckyNumber(132231);

    }

    private static void luckyNumber(int num) {
        int sum1 = 0, sum2 = 0;
        int n = num;

        boolean a=true;
        while(num != 0) {
            if(a) {
                sum1 += num % 10;
            } else {
                sum2 += num % 10;
            }
            a = !a;

            num /=10;
        }
        String st = (sum1 == sum2) ? "lucky" : "unlucky";
        System.out.println("Number " + n + " is " + st);
    }

    private static int countDigits(int num) {
        if (num == 0) return 1;

        int res = 0;
        for (;num != 0; res++, num = num / 10);
        return res;
    }
}
