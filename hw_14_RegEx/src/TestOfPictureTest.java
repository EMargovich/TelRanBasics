import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOfPictureTest {

    //Test 1. All Europe pictures
    @Test
    void testEuropePictures() {
        assertTrue(TestPicture.testPictureNames("Paris\\20140101_090000.jpg",1));
    }

    @Test
    void testEuropePicturesFalse() {
        assertFalse(TestPicture.testPictureNames("Chicago\\20150301_120001.png",1));
    }

    //Test 2. All autumn pictures
    void testAutumnPictures() {
        assertTrue(TestPicture.testPictureNames("Paris\\20150501_231035.gif",2));
    }

    @Test
    void testAutumnPicturesFalse() {
        assertFalse(TestPicture.testPictureNames("Chicago\\20150301_120001.png",2));
    }

    //Test 3  All 2015 spring pictures

    @Test
    void test2015SpringPictures() {
        assertTrue(TestPicture.testPictureNames("Paris\\20150501_231035.gif",3));
    }

    @Test
    void testA2015SpringPicturesFalse() {
        assertFalse(TestPicture.testPictureNames("London\\20151001_231035.jpg",3));
    }

    //Test 4. * All night pictures (from 18:00 till 24:00)
    @Test
    void testNightPictures() {
        assertTrue(TestPicture.testPictureNames("Paris\\20150301_211035.jpg",4));
    }

    @Test
    void testNightPicturesFalse() {
        assertFalse(TestPicture.testPictureNames("London\\20140205_150000.jpg",4));
    }

    //Test 5. * All night pictures from Chicago
    @Test
    void testNightChicagoPictures() {
        assertTrue(TestPicture.testPictureNames("Chicago\\20151111_232000.png",5));
    }

    @Test
    void testNightChicagoPicturesFalse() {
        assertFalse(TestPicture.testPictureNames("Chicago\\20151111_152000.png",5));
    }

    //Test 6. * All jpg and png pictures
    @Test
    void testJpgPngPictures() {
        assertTrue(TestPicture.testPictureNames("Chicago\\20151111_232000.png",6));
    }

    @Test
    void testJpgPngPicturesFalse() {
        assertFalse(TestPicture.testPictureNames("Chicago\\20151111_152000.gif",6));
    }


}
