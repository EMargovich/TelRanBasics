public class ArrayRefAppl {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("x before = " + x);

        pow2Var(x);
        System.out.println("x after = " + x);

        Integer b = 10;
        Integer y;
        y = b;
        b = 15;

        System.out.println("y = " + y + " b = " + b);

        int[] arr = {1, 2, 3};
        System.out.println("arr[1] before = " + arr[1]);
        pow2Arr(arr); //В этом случае мы передаем ссылку, а не значения массива
        System.out.println("arr[1] after = " + arr[1]);

        pow2Var((Integer) arr[1]);
        System.out.println("arr[1] after pow2Var= " + arr[1]);
    }

    private static void pow2Arr(int[] ar) {
        ar[1] = ar[1] * ar[1];
        System.out.println("arr[1] int = " + ar[1]);
    }

    private static void pow2Var(Integer x) {
        x = x * x;
        System.out.println("In pow2Var x int = " + x);
    }
}