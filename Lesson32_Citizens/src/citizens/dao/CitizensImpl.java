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
                    String ln1 = p1.getLastName();
                    String ln2 = p2.getLastName();
                    int res = ln1 == null && ln2 == null ? 0 : ln1 == null ? 1
                            : ln2 == null? -1 : ln1.compareTo(ln2);
                    //Old redaction
//                    int res = p1.getLastName().compareTo(p2.getLastName());
                    return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
                };
        ageComparator =
                (p1, p2) -> {
                    Integer age1 = p1.getBirthDate() == null ? null : p1.getAge();
                    Integer age2 = p2.getBirthDate() == null ? null : p2.getAge();

                    int res = age1 == null && age2 == null ? 0 : age1 == null ? 1
                            : age2 == null? -1 : age1.compareTo(age2);

                    //Old redaction
                    //int res = Integer.compare(p1.getAge(), p2.getAge());
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
//            if(index >= 0)
//                return idList.get(index);
//            return null;
            return index < 0 ? null : idList.get(index);
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {

        List<Person> res = new ArrayList<>();
        for (Person p : ageList) {
            if (p.getAge() >= minAge && p.getAge() <= maxAge) {
                res.add(p);
            }
        }

        return res;

//        LocalDate startBirthDate = LocalDate.now().minusYears(maxAge);
//        Person pattern = new Person(Integer.MIN_VALUE,null,null, startBirthDate);
//        int start = Collections.binarySearch(ageList,pattern, ageComparator);
//        start = -start - 1;
//
//        LocalDate endBirthDate = LocalDate.now().minusYears(minAge);
//        pattern = new Person(Integer.MAX_VALUE,null,null, endBirthDate);
//        int end = Collections.binarySearch(ageList,pattern, ageComparator);
//        end = -end - 1;
//        return ageList.subList(start, end);

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
