import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamHomework {

    public static void main(String[] args) {

        //==============================1===========================
        List<String> names = Arrays.asList(" alice ", "BOB", null, " Eve ", "");

        names = names.stream()
                .filter(s -> s != null && s != "")
                .map(String::trim)
                .map(s -> s.substring(0,1).toUpperCase()
                        +s.substring(1,s.length()).toLowerCase())
                .toList();

        System.out.println("Task 1: " + names);

        //============================2==============================
        List<String> xs = List.of("10"," -3 ","x","42", " 4 2 ", "-1-1","--1", "2,3", "6.8");

        int sum = xs.stream()
                .map(String::trim)
                .filter(s -> s.matches("-?[0-9]*"))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Task 2: sum = " + sum);

        //============================3==============================

        List<String> titles = List.of("java", "Zebra", "apple");

        System.out.println("Task 3:");
        titles.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .forEach(System.out::println);

        //============================4==============================

        String str = "lorem ipsum dolor sit amet amet";
        Map<Integer, Long> res = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(String::length,Collectors.counting()));

        System.out.println("Task 4: res " + res);

        //============================5==============================
        List<String> sentences = List.of(
                "Hello world",
                "world of Streams",
                "HELLO lambda"
        );

        List<String> res5 = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .toList();
        System.out.println("Task 5: " + res5);

        //============================6==============================
        List<Integer> res6 = IntStream.range(1,1000).
            filter(StreamHomework::isPrime)
                .limit(10)
                .boxed()
                .toList();
        System.out.println("Task 6: " + res6);

    }

    static boolean isPrime(int i) {
        if (i == 1) return false;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
