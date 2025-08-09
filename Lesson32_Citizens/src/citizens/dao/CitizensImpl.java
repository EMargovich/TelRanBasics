package citizens.dao;

import citizens.entities.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class CitizensImpl implements Citizens {

    //private int size;
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;

    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;

    static {
        lastNameComparator =
                (p1, p2) -> {
                    int res = p1.getLastName().compareTo(p2.getLastName());
                    return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
                };
        ageComparator =
                (p1, p2) -> {
                    int res = Integer.compare(p1.getAge(), p2.getAge());
                    return  res !=0 ? res : Integer.compare(p1.getId(), p2.getId());
                };
    }

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    @Override
    public boolean add(Person person) {
        if(person == null)
            return false;

        int index = Collections.binarySearch(idList,person);
        if(index >= 0)
            return false;
        index = -index - 1;
        idList.add(index, person);

        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = -index - 1;
        lastNameList.add(index,person);

        index = Collections.binarySearch(ageList, person, ageComparator);
        index = -index - 1;
        ageList.add(index,person);

        return true;
    }

    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if(victim != null) {
            idList.remove(victim);
            lastNameList.remove(victim);
            ageList.remove(victim);
            return true;
        }
        return false;
    }

    @Override
    public Person find(int id) {
            Person pattern = new Person(id,null,null,null);
            int index = Collections.binarySearch(idList, pattern);
            if(index >= 0)
                return idList.get(index);
            return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {

        LocalDate startBerthDate = LocalDate.now().minusYears(maxAge);
        Person pattern = new Person(Integer.MIN_VALUE,null,null, startBerthDate);
        int start = Collections.binarySearch(ageList,pattern, ageComparator);
        start = -start - 1;

        LocalDate endBerthDate = LocalDate.now().minusYears(minAge);
        pattern = new Person(Integer.MAX_VALUE,null,null, endBerthDate);
        int end = Collections.binarySearch(ageList,pattern, ageComparator);
        end = -end - 1;

        return ageList.subList(start, end);
    }

    @Override
    public Iterable<Person> find(String lastName) {

        Person pattern = new Person(Integer.MIN_VALUE,null,lastName,null);
        int start = Collections.binarySearch(lastNameList,pattern,lastNameComparator);
        start = -start - 1;

        pattern = new Person(Integer.MAX_VALUE,null,lastName,null);
        int end = Collections.binarySearch(lastNameList, pattern, lastNameComparator);
        end = -end - 1;

        return lastNameList.subList(start, end);
    }

    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;
    }

    @Override
    public int size() {
        return idList.size();
    }
}
