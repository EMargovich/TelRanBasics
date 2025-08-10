package citizens.tests;

import citizens.dao.Citizens;
import citizens.dao.CitizensImpl;
import citizens.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CitizensImplTests {

    Citizens citizens;
    Person[] persons;

    Person p1 = new Person(666, "DDD", "AAAAA", LocalDate.of(1950,1,1));
    Person p2wrong = new Person(666, "DDD", "AAAAA", LocalDate.of(1950,1,1));
    Person p3 = new Person(777, "DDD", "AAAAA", LocalDate.of(1950,1,1));


    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl();
        persons = new Person[5];
        persons[0] = new Person(111, "AAA", "DDDDD", LocalDate.of(1960,1,1));
        persons[1] = new Person(222, "BBB", "CCCCC", LocalDate.of(1960,2,1));
        persons[2] = new Person(333, "CCC", "CCCCC", LocalDate.of(1980,1,1));
        persons[3] = new Person(444, "DDD", "AAAAA", LocalDate.of(1950,1,1));
        persons[4] = new Person(555, "DDD", "AAAAA", LocalDate.of(1950,1,1));

        for (Person person : persons) {
            citizens.add(person);
        }

        assertEquals(5, citizens.size());
    }

    @Test
    void testAdd_Normal() {
        assertTrue(citizens.add(p1));
        assertEquals(6,citizens.size());
    }





    @Test
    void testFindByAge() {
        Person[] personsByDate = {persons[0], persons[1]};
        List<Person> expected = Arrays.asList(personsByDate);
        Iterable<Person> actual = citizens.find(50,70);
        assertIterableEquals(expected, actual);
    }

    @Test
    void testFindByLastName() {
        Person[] personsByLastName = {persons[1], persons[2]};
        List<Person> expected = Arrays.asList(personsByLastName);
        assertIterableEquals(expected, citizens.find("CCCCC"));
    }


}
