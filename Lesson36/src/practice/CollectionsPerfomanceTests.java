package practice;

import java.util.*;
import java.util.Random;

public class CollectionsPerfomanceTests {
    static final int N = 10_000;
    static final int CONTAINS = 10_000;
    static final int REMOVE = 1000;

    public static void main(String[] args) {
        int[] values = fillArrow(N);
        int[] contaisArr = fillArrayContains(values, CONTAINS);
        int[] removeArr = fillArrayRemoveExists(values, REMOVE);
        int[] removeArrNotExist = fillArrayRemoveNotExists(values, REMOVE);

        System.out.println("===============Add==============");
        add_ArrayList(values);
        add_LinkedList(values);
        add_HashSet(values);
        add_LinkedHashSet(values);
        add_TreeSet(values);

        //==========================
        System.out.println("===============Contains==============");
        System.out.println();
        contains_ArrayList(values, contaisArr);
        contains_LinkedList(values, contaisArr);
        contains_HashSet(values, contaisArr);
        contains_LinkedHashSet(values, contaisArr);
        contains_TreeSet(values, contaisArr);

        //==========================
        System.out.println("===============Remove==============");

        remove_ArrayList(values, removeArr);
        remove_LinkedList(values, removeArr);
        remove_HashSet(values, removeArr);
        remove_LinkedHashSet(values, removeArr);
        remove_TreeSet(values, removeArr);

        //==========================
        System.out.println("===============Remove not exist==============");
        remove_ArrayList(values, removeArrNotExist);
        remove_LinkedList(values, removeArrNotExist);
        remove_HashSet(values, removeArrNotExist);
        remove_LinkedHashSet(values, removeArrNotExist);
        remove_TreeSet(values, removeArrNotExist);

        System.out.println("===============Iterate==============");
        iterate_ArrayList(values);
        iterate_LinkedList(values);
        iterate_HashSet(values);
        iterate_LinkedHashSet(values);
        iterate_TreeSet(values);


    }

    private static void iterate_TreeSet(int[] values) {
        Set<Integer> set = new TreeSet<>();
        for (int i : values)
            set.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : set) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("Time for iterate TreeSet = " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void iterate_LinkedHashSet(int[] values) {
        Set<Integer> set = new LinkedHashSet<>(N);
        for (int i : values)
            set.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : set) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("Time for iterate LinkedHashSet = " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void iterate_HashSet(int[] values) {
        Set<Integer> set = new HashSet<>(N);
        for (int i : values)
            set.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : set) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("Time for iterate HashSet = " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void iterate_LinkedList(int[] values) {
        List<Integer> list = new LinkedList<>();
        for (int i : values)
            list.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : list) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("Time for iterate LinkedList = " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void iterate_ArrayList(int[] values) {
        List<Integer> list = new ArrayList<>(N);
        for (int i : values)
            list.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : list) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("Time for iterate ArrayList = " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void remove_TreeSet(int[] values, int[] removeArr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : values) set.add(i);

        long start = System.nanoTime();

        int count = 0;
        for (int i : removeArr) {
            if (set.remove(i))
                count++;
        }
        long end = System.nanoTime();
        System.out.println("Time for remove in TreeSet  = "
                + (end - start)/100 + " ms" + " we removed " + count + " elements");}

    private static void remove_LinkedHashSet(int[] values, int[] removeArr) {
        Set<Integer> set = new LinkedHashSet<>(N);
        for (int i : values) set.add(i);

        long start = System.nanoTime();

        int count = 0;
        for (int i : removeArr) {
            if (set.remove(i))
                count++;
        }
        long end = System.nanoTime();
        System.out.println("Time for remove in LinkedHashSet  = "
                + (end - start)/100 + " ms" + " we removed " + count + " elements");
    }

    private static void remove_HashSet(int[] values, int[] removeArr) {
        Set<Integer> set = new HashSet<>(N);
        for (int i : values) set.add(i);

        long start = System.nanoTime();

        int count = 0;
        for (int i : removeArr) {
            if (set.remove(i))
                count++;
        }
        long end = System.nanoTime();
        System.out.println("Time for remove in HashSet  = "
                + (end - start)/100 + " ms" + " we removed " + count + " elements");
    }

    private static void remove_LinkedList(int[] values, int[] removeArr) {
        List<Integer> list = new LinkedList<>();
        for (int i : values) list.add(i);

        long start = System.nanoTime();

        int count = 0;
        for (int i : removeArr) {
            if (list.remove((Integer) i))
                count++;
        }
        long end = System.nanoTime();
        System.out.println("Time for remove in LinkedList  = "
                + (end - start)/100 + " ms" + " we removed " + count + " elements");
    }


    private static void remove_ArrayList(int[] values, int[] removeArr) {
        List<Integer> list = new ArrayList<>(N);
        for (int i : values) list.add(i);

        long start = System.nanoTime();

        int count = 0;
        for (int i : removeArr) {
            if (list.remove((Integer) i))
                count++;
        }
        long end = System.nanoTime();
        System.out.println("Time for remove in ArrayList  = "
                + (end - start)/100 + " ms" + " we removed " + count + " elements");
    }

    private static int[] fillArrayRemoveExists(int[] values, int remove) {
        Random r = new Random();
        int[] ar = new int[remove];

        for (int i = 0; i < ar.length; i++) {
            ar[i] = values[r.nextInt(values.length)];
        }
        return ar;

    }

    private static int[] fillArrayRemoveNotExists(int[] values, int remove) {
        Random r = new Random();
        int[] ar = new int[remove];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt(100_000, 200_000);
        }
        return ar;
    }

    private static void contains_TreeSet(int[] values, int[] contaisArr) {
        Set<Integer> set = new TreeSet<>();

        for (int i : values) set.add(i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : contaisArr) {
            if (set.contains(i)) count++;
        }
        long end = System.nanoTime();
        System.out.println("Time for contains in TreeSet  = "
                + (end - start) / 100 + " ms" + " we found " + count + " elements");
    }

        private static void contains_LinkedHashSet(int[] values, int[] contaisArr) {
        Set<Integer> set = new LinkedHashSet<>(N);

        for (int i : values) set.add(i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : contaisArr) {
            if (set.contains(i)) count++;
        }
        long end = System.nanoTime();
        System.out.println("Time fir contains in LinkedList  = "
                + (end - start)/100 + " ms" + " we found " + count + " elements");
    }

    private static void contains_HashSet(int[] values, int[] contaisArr) {
        Set<Integer> set = new HashSet<>(N);

        for (int i : values) set.add(i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : contaisArr) {
            if (set.contains(i)) count++;
        }
        long end = System.nanoTime();
        System.out.println("Time fir contains in HashSet  = "
                + (end - start)/100 + " ms" + " we found " + count + " elements");
    }

    private static void contains_LinkedList(int[] values, int[] contaisArr) {
        List<Integer> list = new LinkedList<>();

        for (int i : values) list.add(i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : contaisArr) {
            if (list.contains(i)) count++;
        }
        long end = System.nanoTime();
        System.out.println("Time fir contains in linked list  = "
                + (end - start)/100 + " ms" + " we found " + count + " elements");
    }

    private static void contains_ArrayList(int[] values, int[] contaisArr) {
        List<Integer> list = new ArrayList<>(N);

        for (int i : values) list.add(i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : contaisArr) {
            if (list.contains(i)) count++;
        }
        long end = System.nanoTime();
        System.out.println("Time fir contains in array list  = "
                + (end - start)/100 + " ms" + " we found " + count + " elements");
    }

    private static int[] fillArrayContains(int[] values, int contains) {

        Random r = new Random();
        int[] ar = new int[contains];
        int half = contains/2;
        for (int i = 0; i < half; i++) {
            ar[i] = values[r.nextInt(values.length)];
        }
        for (int i = half; i < values.length; i++) {
            ar[i] = r.nextInt(100_000, 200_000);
        }
        return ar;
    }

    private static void   add_TreeSet(int[] values) {
        Set<Integer> set = new TreeSet<>();
        long start = System.nanoTime();
        for (int i : values) set.add(i);
        long end = System.nanoTime();
        System.out.println("Add to TreeSet time = " + (end - start)/100 + " ms");
    }

    private static void  add_LinkedHashSet(int[] values) {
        Set<Integer> set = new LinkedHashSet<>(N);
        long start = System.nanoTime();
        for (int i : values) set.add(i);
        long end = System.nanoTime();
        System.out.println("Add to LinkedHashSet time = " + (end - start)/100 + " ms");
    }

    private static void  add_HashSet(int[] values) {
        Set<Integer> set = new HashSet<>(N);
        long start = System.nanoTime();
        for (int i : values) set.add(i);
        long end = System.nanoTime();
        System.out.println("Add to HashSet time = " + (end - start)/100 + " ms");
    }

    private static void  add_LinkedList(int[] values) {
        List<Integer> list = new LinkedList<>();
        long start = System.nanoTime();
        for (int i : values) list.add(i);
        long end = System.nanoTime();
        System.out.println("Add to LinkedList time = " + (end - start)/100 + " ms");
    }

    private static void add_ArrayList(int[] values) {
        List<Integer> list = new ArrayList<>(N);
        long start = System.nanoTime();
        for (int i : values) list.add(i);
        long end = System.nanoTime();
        System.out.println("Add to ArrayList time = " + (end - start)/100 + " ms");
    }


    private static int[] fillArrow(int n) {
        int[] ar = new int[n];
        Random r = new Random();
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt(0, 100_000)             ;
        }
        return ar;
    }
}
