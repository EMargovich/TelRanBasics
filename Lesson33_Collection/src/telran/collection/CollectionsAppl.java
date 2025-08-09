package telran.collection;

import java.util.*;

public class CollectionsAppl {
    //Exist utility class Collections. It contains static methods fo collections
    //Sort, copy (high speed hardware list to list), fill (change all elements on one),
    // synchronise, shuffle,
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("HTML", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI", "Bootstrap", "Material UI");
        String[] str = {"HTML", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI"};
        List<String> list2 = List.of(str);
        List<String> list3 = Arrays.asList(str);
        List<String> list4 = Arrays.asList("HTML", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI");
        List<String> list5 = Arrays.asList("HTML", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI");

        Collections.sort(list1);
        System.out.println(list1);

        System.out.println(Collections.binarySearch(list1, "Bootstrap"));

      Comparator<String> c = Comparator.comparingInt(String::length);
      Collections.sort(list1, c);
      System.out.println(list1);
      System.out.println(Collections.binarySearch(list1, "Bootstrap", c));

//        Collections.sort(list3);
//        System.out.println(list3);
//
//        Collections.fill(list1, "Java");
//        System.out.println(list1);
//        Collections.fill(list3, "Java");
//        System.out.println(list3);
//
//        Collections.shuffle(list3);
//        System.out.println("Shuffle \n" + list3);
//
//        Random r = new Random(123);
//
//        Collections.shuffle(list4, r);
//        System.out.println(list4);
//
//        Collections.shuffle(list5, r);
//        System.out.println(list5);
//
//        String min = Collections.min(list1);
//        String max = Collections.max(list1);
//
//        System.out.println("min: " + min + " max: " + max);
//
//        min = Collections.min(list1, c);
//        max = Collections.max(list1, c);
//
//        System.out.println("min: " + min + " max: " + max);

        System.out.println(Collections.frequency(list1, "Bootstrap"));

        Collections.replaceAll(list1, "HTML", "HTML5");
        System.out.println(list1);

        Collections.rotate(list1, 2);
        System.out.println(list1);

        Collections.reverse(list1);
        System.out.println(list1);

        List<String> listNew = Arrays.asList("HTML6", "CSS6");
        System.out.println(Collections.disjoint(list1,listNew));

        Collections.emptyList(); //Return immutable list


    }
}