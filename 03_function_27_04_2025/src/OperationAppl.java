public class OperationAppl {

    public static void main(String[] args) {

        int x = 50;
        int y = 20;
        double z = (double) x /y;
        double k = x / (y * 1.);

        System.out.println(z);

        System.out.println(k);

        x = (18 % 7);

        y = 18 / 7;

        System.out.println(x);
        System.out.println(y);

        x = 10;
        System.out.println(x);
        boolean check = x > (int) 10.5;
        System.out.println(check);

        x -= 5;
        x++;
        x--;

        System.out.println(x);

        int age = 17;
        double vol = age >= 18 ? 2 : 42;

        System.out.println(vol);

    }
}
