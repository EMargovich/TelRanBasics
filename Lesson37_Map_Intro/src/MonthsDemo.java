import java.util.*;
import java.util.function.Predicate;


public class MonthsDemo {
    public static void main(String[] args) {
        //Map<String, Integer> months = new HashMap<>();
        Map<String, Integer> months = new TreeMap<>();

        fillMap(months);

        System.out.println(months);

        System.out.println("put jan = 100. Old value is "+months.put("jan", 100));

        System.out.println(months);

        System.out.println( " put may = 5. Old value =  " + months.put("may", 5));

        //putAll add map to map. void
        //putIfAbsent - add if key is not exist

        System.out.println(months.putIfAbsent("jan", 1));
        System.out.println(months);
        System.out.println(months.putIfAbsent("jun", 6));
        System.out.println(months);

        Map<String, Integer> months1 = new HashMap<>();
        months1.put("jan",1000);
        months1.put("feb",20);;
        months1.put("jun", 6);
        months1.put("jul", 7);
        months1.put("aug", 8);

        System.out.println("Months 1 " + months1);

        //months.putAll(months1);

        System.out.println(months1);

        months1.putAll(months);

        System.out.println(months1);

        System.out.println(months.containsKey("jan"));
        System.out.println(months.containsKey("JAN"));

        System.out.println(months.containsValue(4));
        System.out.println(months.containsValue(16));

        System.out.println(months.size());

        System.out.println(months.get("mar"));
        System.out.println(months.get("Mar"));

        System.out.println(months.getOrDefault("mar",777));
        System.out.println(months.getOrDefault("Mar",777));

        System.out.println(months.remove("jan"));
        System.out.println(months);
        System.out.println(months.remove("jan"));
        System.out.println(months.remove("jan",6));
        System.out.println(months);
        System.out.println(months.remove("jan",6));
        System.out.println(months);

        months1.clear();
        System.out.println(months1);

        System.out.println();

        //entrySet() - return Set, in which our Entry is element
        //keySet() - return Set with kees only
        //values() - return List

        months.put("jan", 1);

        iterateEntries(months);
        iterateMonthNames(months);
        iterateMonthNumbers(months);

        months.values().removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t%2 == 0;
            }
        });

        System.out.println(months);
    }

    private static void iterateMonthNumbers(Map<String, Integer> months) {
        for(Integer val : months.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println(months.values().getClass());
    }

    private static void iterateMonthNames(Map<String, Integer> months) {
        for (String name : months.keySet()) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    private static void iterateEntries(Map<String, Integer> months) {
        for (Map.Entry<String, Integer> entry : months.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Entry " + entry + " \nKey: " + key + " Value: " + value);
        }
    }



    private static void fillMap(Map<String, Integer> months) {
        months.put("jan",1);
        months.put("feb",2);
        months.put("mar",3);
        months.put("apr", 4);
//        months.put("may", 5);
//        months.put("jun", 6);
//        months.put("jul", 7);
//        months.put("aug", 8);
//        months.put("sep", 9);
//        months.put("oct", 10);
//        months.put("nov", 11);
//        months.put("dec", 12);
    }


}
