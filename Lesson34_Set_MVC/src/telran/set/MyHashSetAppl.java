package telran.set;

public class MyHashSetAppl {

    public static void main(String[] args) {
        MyHashSet<String> mySet = new MyHashSet<>();
        System.out.println("Capacity: " + mySet.getCapacity());
        System.out.println("Size: " + mySet.size());
        mySet.add("sss");
        mySet.add("aaa");
        mySet.add("bbb");
        mySet.add("ccc");
        mySet.add("AAA");

        display(mySet);
        System.out.println("Size: " + mySet.size());

        System.out.println("Add repeat object - " + mySet.add("ccc"));

        System.out.println("Capacity: " + mySet.getCapacity());
        System.out.println("Size: " + mySet.size());

        System.out.println(mySet.contains("AAA"));
        System.out.println(mySet.contains("AA"));

        System.out.println(mySet.remove("aaa"));
        System.out.println("Size: " + mySet.size());
        System.out.println(mySet.contains("aaa"));
        display(mySet);
        System.out.println(mySet.add("aaa"));
        display(mySet);


    }

    public static void display(MyHashSet<String> str) {
        System.out.print("All hash set:  ");
        for (String s : str) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
