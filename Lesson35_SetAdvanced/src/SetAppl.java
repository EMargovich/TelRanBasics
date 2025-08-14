import java.util.*;

public class SetAppl {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(6);
        set1.add(1);
        set1.add(9);
        set1.add(10);
        set1.add(3);

        System.out.println(set1);

        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(5);
        set2.add(6);
        set2.add(1);
        set2.add(9);
        set2.add(10);
        set2.add(3);

        System.out.println(set2);

        Integer[] numbers = {100, 400, 100, 5, 4, 100, 9, 9, 400, 4, 5, 120};

        List<Integer> listNumbers = Arrays.asList(numbers);

        System.out.println(removeDuplicates(listNumbers));
        System.out.println(removeDuplicateLinkedHash(listNumbers));
    }

    private static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if(!newList.contains(i))
                newList.add(i);
        }
        return newList;
    }

    private static List<Integer> removeDuplicateLinkedHash(List<Integer> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
}
