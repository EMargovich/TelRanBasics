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

    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl();
        persons = new Person[4];
        persons[0] = new Person(111, "AAA", "DDDDD", LocalDate.of(1960,1,1));
        persons[1] = new Person(222, "BBB", "CCCCC", LocalDate.of(1960,2,1));
        persons[2] = new Person(333, "CCC", "CCCCC", LocalDate.of(1980,1,1));
        persons[3] = new Person(444, "DDD", "AAAAA", LocalDate.of(1950,1,1));

        for (Person person : persons) {
            citizens.add(person);
        }
    }

    @Test
    void testFindByAge() {
        Person[] personsByDate = {persons[0], persons[1]};
        List<Person> expected = Arrays.asList(personsByDate);
        assertIterableEquals(expected, citizens.find(50,70));
    }

    @Test
    void testFindByLastName() {
        Person[] personsByLastName = {persons[1], persons[2]};
        List<Person> expected = Arrays.asList(personsByLastName);
        assertIterableEquals(expected, citizens.find("CCCCC"));
    }


}
