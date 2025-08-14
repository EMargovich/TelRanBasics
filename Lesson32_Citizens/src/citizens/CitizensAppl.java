package citizens;

import citizens.dao.CitizensImpl;
import citizens.entities.Person;

import java.time.LocalDate;
import java.util.List;

public class CitizensAppl {

    public static void main(String[] args) {

        Person[] persons = new Person[4];

        persons[0] = new Person(111, "AAA", "DDDDD", LocalDate.of(1960,1,1));
        persons[1] = new Person(222, "BBB", "BBBBB", LocalDate.of(1960,2,1));
        persons[2] = new Person(333, "CCC", "BBBBB", LocalDate.of(1980,1,1));
        persons[3] = new Person(444, "DDD", "AAAAA", LocalDate.of(1950,1,1));

        CitizensImpl citizens = new CitizensImpl();

        for (Person person : persons) {
            citizens.add(person);
        }

        printCollections(citizens, "Start print");

        System.out.println(citizens.remove(333));
        System.out.println(citizens.remove(222));
        System.out.println(citizens.remove(444));
        System.out.println(citizens.remove(444));

        printCollections(citizens, "After remove");



    }

    private static void printCollections(CitizensImpl list, String comment) {
        System.out.println(comment);
        System.out.println("Sorted by id \n" + list.getAllPersonsSortedById());
        System.out.println("Sorted by age \n" + list.getAllPersonsSortedByAge());
        System.out.println("Sorted by Last name \n" + list.getAllPersonsSortedByLastName());
    }

}


