package telran.list;

import telran.list.model.MyArrayList;

public class MyArrayListAppl {

    public static void main(String[] args) {
        System.out.println("================Test MyArrayList with String==========");
        testString();
        System.out.println("================Test MyArrayList with Integer=========");

    }

    private static void testInteger() {
    }

    private static void testString() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("AAAA");
        list.add("BBBB");
        list.add("CCCC");

        printList(list);

        list.add(1, "SSSS");
        printList(list);

        System.out.println(list.get(1));
        String str1 =  list.set(2,"HHHH");
        printList(list);
        System.out.println(str1);

        System.out.println(list.contains(str1));
        System.out.println(list.contains("AAAA"));

        System.out.println(list.indexOf("CCCC"));
        System.out.println(list.indexOf("C"));

        list.remove(1);
        printList(list);
        list.remove("AAAA");
        printList(list);

    }

    private static void printList(MyArrayList<String> list) {
        System.out.println("List (" + list.size() + ")" + toStr(list));
    }

    private static String toStr(MyArrayList<String> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i<list.size()-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
