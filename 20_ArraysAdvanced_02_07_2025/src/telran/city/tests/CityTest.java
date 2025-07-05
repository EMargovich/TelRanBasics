package telran.city.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.city.model.City;

import java.util.Arrays;
import java.util.Comparator;

public class CityTest {
    City[] usa;

    @BeforeEach
    void setUp() {
      usa = new City[8];
      usa[0] = new City("Denver", 600_000);
      usa[1] = new City("Boston", 670_000);
      usa[2] = new City("Chicago", 2_700_000);
      usa[3] = new City("Chicago", 8_700_000);
      usa[4] = new City("Chicago", 3_700_000);
      usa[5] = new City("Atlanta", 770_000);
      usa[6] = new City("New York", 8_500_000);
      usa[7] = new City("Dallas", 1_300_000);
    }

    @Test
    void testComparable() {
        System.out.println("Original array");
        System.out.println(Arrays.toString(usa));
        Arrays.sort(usa);
        System.out.println("Natural array");
        System.out.println(Arrays.toString(usa));

        City pattern = new City(null, 2_700_000);
        int index = Arrays.binarySearch(usa, pattern);
        System.out.println("Index = " + index);
    }

    @Test void testNameComparator(){
        Comparator<City> comp = (a, b) -> {
            int res = a.getName().compareTo(b.getName());
            return res == 0 ? a.getPopulation() - b.getPopulation() : res;
        };
        Arrays.sort(usa, comp);
        System.out.println("Comparator sort by name:");
        System.out.println(Arrays.toString(usa));
        City pattern = new City("Chicago",3_700_000);
        int index = Arrays.binarySearch(usa, pattern, comp);
        System.out.println("Index = " + index);
    }

    @Test
    void testArrayCopy() {
        City[] copyArr = Arrays.copyOf(usa,usa.length * 2);
        Arrays.sort(copyArr,0,usa.length);
        System.out.println("Copy array after sort ");
        System.out.println(Arrays.toString(copyArr));
        System.out.println("Original array after copy:");
        Arrays.toString(usa);
        System.out.println(Arrays.toString(usa));

        City pattern = new City("Chicago",3_700_000);
        int index = Arrays.binarySearch(copyArr, 0, usa.length, pattern);
        System.out.println("Index = " + index);
    }

    private City[] copyArray(City[] usa) {
        City[] res = new City[usa.length];

        for (int i = 0; i < usa.length; i++) {
            res[i] = usa[i];
        }
        return res;
    }

    @Test
    void testCopyOfRange() {
        City[] copyArray = Arrays.copyOfRange(usa, 2, 6);
        System.out.println(Arrays.toString(copyArray));
    }

    @Test
    void testSystemArrayCopy() {
        City[] copyArr = new City[usa.length * 2];
        System.arraycopy(usa,0,copyArr,3,usa.length);
        printArray(copyArr);
    }

    private void printArray(City[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
