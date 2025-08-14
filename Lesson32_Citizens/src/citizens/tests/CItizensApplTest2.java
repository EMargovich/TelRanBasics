package citizens.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import citizens.dao.Citizens;
import citizens.dao.CitizensImpl;
import citizens.entities.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    class CItizensApplTest2 {
        Citizens citizens;
        static final LocalDate NOW = LocalDate.now();
        Person p1,p2,p3,p4,p5,p6,p7;

        @BeforeEach
        void setUp() {
            p1 = new Person(1, "FirstName1", "LastName1", NOW.minusYears(10));
            p2 = new Person(2, "FirstName2", "LastName2", NOW.minusYears(20));
            p3 = new Person(3, "FirstName3", "Smith", NOW.minusYears(20));
            p4 = new Person(4, "FirstName4", "Smith", NOW.minusYears(40));

            // Not Added
            p5 = new Person(5, "John", "Dough", NOW.minusYears(50));
            p6 = new Person(6, "John", "Dough", NOW.minusYears(60));
            p7 = new Person(7, "John", "Dough", NOW.minusYears(50));


            citizens = new CitizensImpl(List.of(p1,p2,p3,p4));
            assertEquals(4, citizens.size());
        }


        // ============== Add Negative ==============
        @Test
        void add_NullPerson() {
            assertFalse(citizens.add(null));
            assertEquals(4, citizens.size());
        }
        @Test
        void add_Duplicate() {
            assertFalse(citizens.add(p1));
            assertEquals(4, citizens.size());
        }

        // ============== Add Positive ==============
        @Test
        void add_Normal() {
            assertTrue(citizens.add(p5));
            assertEquals(5, citizens.size());
        }
        @Test
        void add_NormalDuplicate() {
            assertTrue(citizens.add(p7));
            assertTrue(citizens.add(p5));
            assertTrue(citizens.add(p6));
            assertEquals(7, citizens.size());

            List<Person> sortedById = (List<Person>) citizens.getAllPersonsSortedById();
            List<Person> sortedByIdExpected = List.of(p1,p2,p3,p4,p5,p6,p7);
            assertArrayEquals(sortedByIdExpected.toArray(), sortedById.toArray());

            List<Person> sortedByLastName = (List<Person>) citizens.getAllPersonsSortedByLastName();
            List<Person> sortedByLastNameExpected = List.of(p5,p6,p7,p1,p2,p3,p4);
            assertArrayEquals(sortedByLastNameExpected.toArray(), sortedByLastName.toArray());

            List<Person> sortedByAge = (List<Person>) citizens.getAllPersonsSortedByAge();
            List<Person> sortedByAgeExpected = List.of(p1,p2,p3,p4,p5,p7,p6);
            assertArrayEquals(sortedByAgeExpected.toArray(), sortedByAge.toArray());
        }

        // ============= Remove =============
        @Test
        void remove() {
            assertFalse(citizens.remove(-1));
            assertEquals(4, citizens.size());

            assertFalse(citizens.remove(8));
            assertEquals(4, citizens.size());

            assertTrue(citizens.remove(1));
            assertEquals(3, citizens.size());

            assertFalse(citizens.remove(1));
            assertEquals(3, citizens.size());

            assertNull(citizens.find(1));
        }

        // ============= Find =============
        @Test
        void find() {
            Person p = citizens.find(1);
            assertNotNull(p);
            assertEquals(p1, p);

            assertNull(citizens.find(-1));
            assertNull(citizens.find(5));
        }

        @Test
        void testFindAge() {
            List<Person> personAge =(List<Person>)citizens.find(20,50);
            List<Person> personAgeExpected = List.of(p2, p3, p4);
            assertEquals(personAge.size(), personAgeExpected.size());
            assertIterableEquals(personAgeExpected, personAge);

            citizens.add(p5);
            citizens.add(p6);
            citizens.add(p7);
            personAgeExpected = List.of(p2, p3, p4, p5, p7);
            personAge =(List<Person>)citizens.find(20,50);
            assertEquals(personAge.size(), personAgeExpected.size());
            assertIterableEquals(personAgeExpected, personAge);

            personAge =(List<Person>)citizens.find(10,19);
            assertEquals(1, personAge.size());
            personAgeExpected = List.of(p1);
            assertIterableEquals(personAge, personAgeExpected);
        }

        @Test
        void testFindAgeNegative() {
            List<Person> personAge = (List<Person>) citizens.find(1, 2);
            assertTrue(personAge.isEmpty());

            Person p = new Person(10, null, null, null);
            citizens.add(p);
            citizens.find(10,20);

            Person pp = new Person(11, "Null", "Null", NOW.plusYears(10));
            citizens.add(pp);
            System.out.println(citizens.find(11).getAge());
            System.out.println(citizens.getAllPersonsSortedByAge());
        }

        @Test
        void testFinsLastName() {
            List<Person> personLastName = (List<Person>) citizens.find("Smith");
            List<Person> personLastNameExcepted = List.of(p3, p4);
            assertEquals(2, personLastNameExcepted.size());
            assertIterableEquals(personLastNameExcepted, personLastName);

            citizens.add(p5);
            citizens.add(p6);
            citizens.add(p7);

            personLastName = (List<Person>) citizens.find("Dough");
            personLastNameExcepted = List.of(p5, p6, p7);
            assertEquals(3, personLastNameExcepted.size());
            assertIterableEquals(personLastNameExcepted, personLastName);
        }

        @Test
        void testFinsLastNameNegative() {
            List<Person> personLastName = (List<Person>) citizens.find("HHHHH");
            assertTrue(personLastName.isEmpty());

            personLastName = (List<Person>) citizens.find(null);
            assertTrue(personLastName.isEmpty());
        }
}
