package telran.money.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.money.model.Money;

import java.util.Arrays;
import java.util.Random;

import static telran.arrays.tools.ArrayTools.bubbleSort;
import static telran.arrays.tools.ArrayTools.printArray;

public class MoneyTest {
   Money[] arr;
   Random random = new Random();

   @BeforeEach
   void setUp() {
       arr = new Money[10];
       for (int i = 0; i < arr.length; i++) {
           double lenght = random.nextDouble(129, 152);
           double width = random.nextDouble(70, 73);
           int value = random.nextInt(20, 101);
           arr[i] = new Money(width, lenght, value);
       }
   }

   @Test
    void testComparebleMoney() {
       printArray(arr);
       bubbleSort(arr);
       printArray(arr);
   }

   @Test
   void testComparatorMoney() {
       System.out.println("Test Comparator");
       //bubbleSort(arr, (a, b) -> (int) (a.getLength() - b.getLength()));
       Arrays.sort(arr, (a, b) -> Double.compare(a.getSquare(), b.getSquare()));
       printArray(arr);
   }
}
