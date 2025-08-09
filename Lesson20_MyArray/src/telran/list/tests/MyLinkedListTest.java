package telran.list.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.list.interfaces.IList;
import telran.list.model.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    //MyLinkedList<String> stringList;
    //MyLinkedList<Integer> intList;

    IList<String> stringList;
    IList<Integer> intList;

    @BeforeEach
    void setUp() {
        stringList = new MyLinkedList<String>();
        intList = new MyLinkedList<>();

        stringList.add("AAA");
        stringList.add("BBB");
        stringList.add("CCC");

        intList.add(1);
        intList.add(2);
        intList.add(3);
    }

    @Test
    void testStringIteratorPositive() {
        Iterator<String> it = stringList.iterator();
        //First element exist
        assertTrue(it.hasNext());
        assertEquals("AAA", it.next());
        assertEquals("BBB", it.next());
        assertEquals("CCC", it.next());
        //Next element do not exist
        assertFalse(it.hasNext());
    }

    @Test
    void testStringIteratorNegative() {
        Iterator<String> it = stringList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        try {
            it.next();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }


    @Test
    void testStringAddPositive() {
        assertTrue(stringList.add(1, "XXX"));
        assertEquals(4,stringList.size());
        assertEquals("XXX", stringList.get(1));
        assertEquals("CCC", stringList.get(3));
        assertTrue(stringList.add(1, null));
        assertEquals(5,stringList.size());
        assertEquals("XXX", stringList.get(2));
    }

    @Test
    void testStringAddNegative() {
        try {
            stringList.add(-1,"SSS");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            stringList.add(6,"SSS");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testStringGetPositive() {
        assertEquals("BBB", stringList.get(1));
        assertEquals("CCC", stringList.get(2));
    }

    @Test
    void testStringGetNegative() {
        try {
            stringList.get(-1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            stringList.get(6);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void size() {
        assertEquals(3,stringList.size());
        stringList.add(1, "XXX");
        assertEquals(4,stringList.size());
        stringList.remove(1);
        assertEquals(3,stringList.size());
    }

    @Test
    void testIndexOfLastIndexOf() {
        assertEquals(1, stringList.indexOf("BBB"));
        assertEquals(1, stringList.lastIndexOf("BBB"));
        stringList.add("BBB");
        stringList.add("BBB");
        assertEquals(1, stringList.indexOf("BBB"));
        assertEquals(4, stringList.lastIndexOf("BBB"));
        stringList.add(null);
        assertEquals(5, stringList.lastIndexOf(null));
        assertEquals(5, stringList.indexOf(null));
        stringList.add("CCC");
        assertEquals(1, stringList.indexOf("BBB"));
        assertEquals(4, stringList.lastIndexOf("BBB"));

        //negative
        assertEquals(-1, stringList.lastIndexOf("SSS"));
        assertEquals(-1, stringList.indexOf("SSS"));
    }


    @Test
    void remove() {
    }

    @Test
    void testRemoveStringRemovePositiveByIndex() {
        assertEquals("BBB",stringList.remove(1));
        assertEquals(1,stringList.indexOf("CCC"));
        assertFalse(stringList.contains("BBB"));

    }

    @Test
    void testRemoveStringRemovePositiveByObject() {
        assertTrue(stringList.remove("BBB"));
        assertEquals(2,stringList.size());
        assertFalse(stringList.contains("BBB"));
    }

    @Test
    void testRemoveStringRemoveNegativeByIndex() {
        try {
            stringList.remove(-1);
            fail("Expected IndexOutOfBoundaries");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            stringList.remove(3);
            fail("Expected IndexOutOfBoundaries");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testRemoveStringRemoveNegativeByObject() {
        assertFalse(stringList.remove("KKK"));
    }

    @Test
    void contains() {
    }

    @Test
    void testClear() {
        stringList.clear();
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void testStringSetPositiveSet() {
        assertEquals("BBB", stringList.set(1, "GGG"));
        assertEquals("GGG",stringList.get(1));
    }

    @Test
    void testStringSetNegative() {
        try {
            stringList.set(-1,"GGG");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            stringList.set(10,"GGG");
            fail("Expected IndexOutOfBoundaries");
        } catch (IndexOutOfBoundsException e) {

        }
    }

    //=================Integer=================
    @Test
    void testRemoveIntegerPositiveByIndex() {
        assertEquals(2,intList.remove(1));
        assertEquals(2,intList.size());
        assertFalse(intList.contains(2));
    }

    @Test
    void testRemoveIntegerPositiveByObject() {
        assertTrue(intList.remove((Integer) 1));
        assertEquals(2,intList.size());
        assertFalse(intList.contains(1));
    }

    @Test
    void testIntegerIteratorPositive() {
        Iterator<Integer> it = intList.iterator();
        //First element exist
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        //Next element do not exist
        assertFalse(it.hasNext());
    }

    @Test
    void testIntegerIteratorNegative() {
        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        try {
            it.next();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testIntegerAddPositive() {
        assertTrue(intList.add(1, 5));
        assertEquals(4,intList.size());
        assertEquals(5, intList.get(1));
        assertEquals(3, intList.get(3));
        assertTrue(intList.add(1, null));
        assertEquals(5,intList.size());
        assertEquals(3, intList.get(4));
    }

    @Test
    void testIntegerAddNegative() {
        try {
            intList.add(-1,6);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            intList.add(6,9);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testIntegerGetPositive() {
        assertEquals(2, intList.get(1));
        assertEquals(3, intList.get(2));
    }

    @Test
    void testIntegerGetNegative() {
        try {
            intList.get(-1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            intList.get(6);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

      @Test
    void testIntegerOfLastIndexOf() {
        assertEquals(1, intList.indexOf(2));
        assertEquals(1, intList.lastIndexOf(2));
        intList.add((Integer) 2);
        intList.add((Integer) 2);
        assertEquals(1, intList.indexOf(2));
        assertEquals(4, intList.lastIndexOf(2));
        intList.add(null);
        assertEquals(5, intList.lastIndexOf(null));
        assertEquals(5, intList.indexOf(null));
        intList.add((Integer) 4);
        assertEquals(1, intList.indexOf(2));
        assertEquals(4, intList.lastIndexOf(2));

        //negative
        assertEquals(-1, intList.lastIndexOf(9));
        assertEquals(-1, intList.indexOf(9));
    }

    @Test
    void testIntegerSetPositiveSet() {
        assertEquals(2, intList.set(1, 5));
        assertEquals(5, intList.get(1));
    }

    @Test
    void testIntegerSetNegative() {
        try {
            intList.set(-1,9);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            intList.set(10,9);
            fail("Expected IndexOutOfBoundaries");
        } catch (IndexOutOfBoundsException e) {
        }
    }
}