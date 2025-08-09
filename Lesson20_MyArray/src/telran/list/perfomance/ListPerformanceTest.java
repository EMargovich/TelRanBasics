package telran.list.perfomance;

import org.w3c.dom.ls.LSOutput;
import telran.list.interfaces.IList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
    public static void main(String[] args) {
        
        int size = 10_000;
        int middleIndex = size / 2;
        int searchValue = middleIndex;
        
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
       // System.out.println(Integer.toHexString(System.identityHashCode(arrayList)));

        for (int i = 0; i <= size ; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

       // System.out.println(Integer.toHexString(System.identityHashCode(arrayList)));

//        testAddAtIndex(arrayList,0,999999, "Array, add to index 0");
//        testAddAtIndex(linkedList,0,999999, "Linked, add to index 0");
//        System.out.println("To center");
//        testAddAtIndex(arrayList,middleIndex,999999, "Array, add to index 0");
//        testAddAtIndex(linkedList,middleIndex,999999, "Linked, add to index 0");
//        System.out.println("To end");
//        testAddAtIndex(arrayList, size, 999999, "Array, add to index 0");
//        testAddAtIndex(linkedList, size,999999, "Linked, add to index 0");
//        System.out.println("Insert group");
        int count = 100;
        testInsertBulkAtIndex(arrayList, 0, count, "Array list", true);
        testInsertBulkAtIndex(linkedList, 0, count, "Linked list", false);

    }

    private static void testAddAtIndex(List<Integer> list, int index, int value, String listName) {
        long start = System.nanoTime();
        list.add(index,value);
        long end = System.nanoTime();
        System.out.println(listName + " insert by index " + index + ":" + (end - start)/1000 + " ms");
    }

    private static void testInsertBulkAtIndex(List<Integer> list, int index, int count, String listName, boolean useArrayList) {
        List<Integer> bulk;
        if(useArrayList)
            bulk = new ArrayList<Integer>();
        else
            bulk = new LinkedList<>();

        for (int i = 0; i < count ; i++) {
            bulk.add(i);
        }
        long start = System.nanoTime();
        list.addAll(index, bulk);
        long end = System.nanoTime();
        System.out.println(listName + " insert by index " + index + " group " + count + " elements " + (end - start)/1000 + " ms");
    }
}
