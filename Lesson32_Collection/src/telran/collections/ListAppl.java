package telran.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListAppl {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("HTML");
        list.add("CSS");
        list.add("JavaScript");
        list.add("TypeScript");
        list.add("React");
        list.add("Redux");
        list.add("Bootstrap");
        list.add("Material UI");

        System.out.println(list);

        list.remove("JavaScript");

        System.out.println(list);

        list.set(2, "Java");

        System.out.println(list);

        list.add(7, "JavaScript");

        System.out.println(list);

        System.out.println("List 1");
        //В этом случае создается неизменяемый по размеру массив (не поддерживает операции добавлени и удаления элементов,
        //но позволяет их изменять
        //При этом передается ссылка, то есть при изменении будет изменен первоначальный массив
        //Can add null
        //Object wrapper (work with same object)
        List<String> list1 = Arrays.asList("HTM", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI");
        System.out.println(list1);
        list1.set(2, "Java");
        System.out.println(list1);

        String[] str = {"AAAA", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI"};
        System.out.println();
        System.out.println("List2");
        List<String> list2 = Arrays.asList(str);
        System.out.println(list2);

        String s3 = list2.set(2, "Java");
        System.out.println(list2);
        System.out.println(Arrays.toString(str));
        System.out.println(s3);

        System.out.println("================List.of()================");
        //В этом случае создается неизменяемый массив
        //При этом формируется копия массива. If original array changed, this array do not change
        //Do not get null
        //Copy object (do not work with same object)
        List<String> list3 = List.of("AAAA", "CSS", "JavaScript", "TypeScript", "React", "Redux", "Bootstrap", "Material UI");
        List<String> list4 = List.of(str);
        list4.get(1);
        System.out.println(list4.get(1));

        str[0] = "HTML";
        System.out.println(list2);
        System.out.println(list4);

        StringBuilder sb = new StringBuilder("HTML");
        List<StringBuilder> l1 = List.of(sb);
        System.out.println(l1);
        sb.append(5);
        System.out.println(l1);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++
        //Now we can add in list. We return list in original state
        list4 = new ArrayList<>(list4);
        list4.set(3, "Node.js");
        System.out.println(list4);

       // System.out.println(sum("Home"," Jiore","Koiu", "Lpor"));

    }

    public String sum (String a, String b, String ...rest) {
        String res = a + b;
        for (int i = 0; i < rest.length; i++) {
            res += rest[i];
        }
        return res;
    }



}
