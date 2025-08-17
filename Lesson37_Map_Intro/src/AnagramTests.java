import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramTests {

    String word = "electricity";

    @Test
        void anagrammTestPositive() {
        assertTrue(AnagramAppl.isAnagram(word, "electric"));
        assertTrue(AnagramAppl.isAnagram(word, "city"));
        assertTrue(AnagramAppl.isAnagram(word, "tric"));
        assertTrue(AnagramAppl.isAnagram(word, "critic"));
    }

    @Test
    void anagrammTestNegative() {
        assertFalse(AnagramAppl.isAnagram(word, "ellect"));
        assertFalse(AnagramAppl.isAnagram(word, "tot"));
        assertFalse(AnagramAppl.isAnagram(word, "select"));
        assertFalse(AnagramAppl.isAnagram(word, "teeet"));
        assertFalse(AnagramAppl.isAnagram(word, " tet"));
    }
}
