package telran.oddEvenComparator.tools;
import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 2 - o2 % 2 == 0) {
            //Если в этом случае одно четное, то тогда и второе четное. Возвращаем их разницу, так как они должны быть расположены в натуральном порядке
            if (o1 % 2 == 0) {
                return o1 - o2;
            }
            //Если оба нечетные, то возвращаем обратную величину, так как нечетные сортируются в обратном порядке
            else {
                return -(o1 - o2);
            }
        }
        //Далее или первое четное, или второе, но в любом случае они разные. Нечетное всегда будет большим, то есть в конце списка
        if (o1 % 2 == 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

