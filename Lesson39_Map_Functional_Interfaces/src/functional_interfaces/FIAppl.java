package functional_interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FIAppl {
    public static void main(String[] args) {
        Calculator add = (a,b) -> a + b;
        Calculator sub = (a,b) -> a -b;
        Calculator mul = (a,b) -> a*b;
        Calculator div = (a,b) -> b == 0 ? 0 : a / b;
        Calculator max = (a,b) -> a > b ? a : b;
        Calculator add_static = Calculator.add();
        Calculator difThen10 = div.thenAdd(10);

        run("add ", add, 4, 7);
        run("sub ", sub, 4, 7);
        run("mul ", mul, 4, 7);
        run("div ", div, 4, 7);
        run("max ", max, 4, 7);

        run("add_static ", add_static, 4, 7);
        run("div + 10", difThen10, 12, 4);

        BiFunction<Integer, Integer, Integer>
                add_bi = (a, b) -> a + b;

        int res = add_bi.apply(4,7);
        System.out.println("BiFunction add " + res);

        Function<Integer, Integer> sq = a -> a*a;
        int res_sq = sq.apply(5);
        System.out.println(res_sq);

        BiFunction<String, String, Boolean> max_bi = (a, b) -> a.length() > b.length();
        boolean res_b = max_bi.apply("adfs", "sfdfjt");
        System.out.println(res_b);
    }

    public static void run(String label, Calculator c, int a, int b) {
        int res = c.calculate(a,b);
        System.out.printf("%s: %d \n",label, res);
    }
}
