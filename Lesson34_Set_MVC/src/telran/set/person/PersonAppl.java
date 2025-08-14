package telran.set.person;

import telran.set.MyHashSet;

import java.util.*;

public class PersonAppl {

    public static void main(String[] args) {
        Person p1 = new Person(1, "Name1", "Surname1");
        Person p2 = new Person(2, "Name1", "Surname2");
        Person p3 = new Person(3, "Name3", "Surname1");
        MyHashSet<Person> persons = new MyHashSet<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        display(persons);

        Person p4 = new Person(1, "Name5", "Surname1");

        System.out.println("Add person 4 with double id " + persons.add(p4));
        display(persons);

        System.out.println(persons.contains(p4));

        //System.out.println("Remove p4 " + persons.remove(p4));

        //p1.setLasName("Surname 5");

        display(persons);

        Set<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);
        System.out.println(personSet);
        System.out.println(personSet.add(new Person(1, "Name5", "Surname5")));
        personSet.add(new Person(51, "Name5", "Surname5"));
        personSet.add(new Person(25, "Name5", "Surname5"));
        personSet.add(new Person(67, "Name5", "Surname5"));

        List<Person> arrPersons = new ArrayList<>(personSet);
        Collections.sort(arrPersons);
        Set<Person> sortedSet = new LinkedHashSet<>(arrPersons);

        System.out.println(sortedSet);
    }

    public static void display(MyHashSet<Person> persons) {
        System.out.println("All hash set:  ");
        for (Person p : persons) {
            System.out.println(p + " ");
        }
        System.out.println();
    }
}
