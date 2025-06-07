package telran.wrapper.controller;

public class WrapperClassesAppl {

    public static void main(String[] args) {
        int x = 10;
        Integer y = 20;
        System.out.println(x);
        System.out.println(y);
        y += 5;
        System.out.println(y);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(y.TYPE);

        Double d = 0 / 0.0;

        System.out.println(d.isNaN());
        System.out.println(Double.isNaN(d));

        System.out.println(Double.isFinite(d));
        System.out.println(Double.isInfinite(d));

        if(d.isInfinite() || d.isNaN()) {
            System.out.println("Wrong number!");
        }

    }
}
