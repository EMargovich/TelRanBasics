public class HomeWork05 {
    public static void main(String[] args) {

        int res = countDigits2(334);
        System.out.println("Count digits = " + res);

       // luckyNumber(132);
       // luckyNumber(132231);
       //  System.out.println(luckyNumber2(132));
       // System.out.println(luckyNumber2(132231));
       // System.out.println(luckyNumber3(132));
       // System.out.println(luckyNumber3(132231));
        luckyNumber4(132231);

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

    private static int countDigits2(int num) {
        int res = 0;
        do{
            num /= 10;
            res++;
        } while(num != 0);

        return res;
    }

    public static boolean luckyNumber2(int number) {
        int evenPosSum = 0;
        int oddPosSum = 0;
        for (int i = 10, j = 100; i < number; i *= 100 , j *= 100) {
            evenPosSum += number % i / (i/10);
            oddPosSum += number % j / (j/10);
        }
        return evenPosSum == oddPosSum;
    }

    public static boolean luckyNumber3(int num) {
        int evenPosSum = 0;
        int oddPosSum = 0;
        while (num > 0) {
            evenPosSum += num % 10;
            num /=10;
            oddPosSum += num %10;
            num /= 10;
        }
        return evenPosSum == oddPosSum;
    }

    private static void luckyNumber4(int num) {
        int sum = 0;
        while (num !=0) {
            sum = num % 10 - sum;
            num /= 10;
        }

        System.out.println(sum);
    }

}



