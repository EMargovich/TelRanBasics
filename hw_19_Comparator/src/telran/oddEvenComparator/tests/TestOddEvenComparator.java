package telran.oddEvenComparator.tests;

import org.junit.jupiter.api.*;
import telran.oddEvenComparator.tools.OddEvenComparator;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;



public class TestOddEvenComparator {

    Integer[] origin = {1,2,3,4,5,6,7,8,9,3};

    @Test
    public void testOddEvenComparator() {
        printArray(origin);
        OddEvenComparator comparator = new OddEvenComparator();
        Arrays.sort(origin,comparator);
        Integer[] expected = {2,4,6,8,9,7,5,3,3,1};
        assertArrayEquals(expected,origin);
        printArray(origin);
    }

    public static void printArray(Object[] arr) {
        for (Object i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n================");
    }
}
