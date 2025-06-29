package telran.oddEvenComparator.tests;

import org.junit.jupiter.api.Test;
import telran.oddEvenComparator.tools.OddEvenComparator;

import java.util.Arrays;

public class TestOddEvenComparator {

    Integer[] origin = {1,2,3,4,5,6,7,8,9,3};

    @Test
    public void testOddEvenComparator() {
        printArray(origin);
        OddEvenComparator comparator = new OddEvenComparator();
        Arrays.sort(origin,comparator);
        printArray(origin);
    }

    public static void printArray(Object[] arr) {
        for (Object i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n================");
    }
}
