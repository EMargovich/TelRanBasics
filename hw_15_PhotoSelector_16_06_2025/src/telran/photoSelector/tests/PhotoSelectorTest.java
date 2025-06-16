package telran.photoSelector.tests;

import org.junit.jupiter.api.Test;
import telran.photoSelector.tools.*;

import static org.junit.jupiter.api.Assertions.*;

class PhotoSelectorTest {
    private final String[] pictures = {
            "Paris\\20140101_090000.jpg",
            "Paris\\20140201_121005.jpg",
            "Paris\\20150301_211035.jpg",
            "Paris\\20150401_110023.gif",
            "Paris\\20150401_181705.jpg",
            "Paris\\20150501_231035.gif",
            "London\\20140205_090000.jpg",
            "London\\20140205_121005.jpg",
            "London\\20140601_211035.gif",
            "London\\20151001_110023.jpg",
            "London\\20151001_121705.jpg",
            "London\\20151001_231035.jpg",
            "Chicago\\20150301_120001.png",
            "Chicago\\20151111_232000.png"
    };

    @Test
    void testAllEuropePicture() {
        String regex = "^(Paris|London).*";
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        String[] expected = {
                "Paris\\20140101_090000.jpg",
                "Paris\\20140201_121005.jpg",
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_110023.gif",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "London\\20140205_090000.jpg",
                "London\\20140205_121005.jpg",
                "London\\20140601_211035.gif",
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
        };
        assertArrayEquals(expected,actual);
    }

    //Test 2. All autumn pictures
    @Test
    void testAllAutumnPicture() {
        String regex = "\\\\\\d{4}(09|10|11)";
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        String[] expected = {
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected,actual);
    }

//Test 3  All 2015 spring pictures
    @Test
    void testAll2015SpringPicture() {
        String regex = "\\\\2015(03|04|05)";
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        String[] expected = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_110023.gif",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "Chicago\\20150301_120001.png"
        };
        assertArrayEquals(expected, actual);
    }

//Test 4. * All night pictures (from 18:00 till 24:00)
    @Test
    void testAllNightPicture() {
        String regex = "_(1[89]|2[0-4])";
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        String[] expected = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "London\\20140601_211035.gif",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }

    //Test 5. * All night pictures from Chicago

    @Test
    void testAllChicagoNightPicture() {
        String regex = "_(1[89]|2[0-4])";
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        regex = "Chicago";
        actual = PhotoSelector.selectPictures(actual, regex);
        String[] expected = {
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }

    //Test 6. * All jpg and png pictures
    @Test
    void testAllJpgPngPicture() {
        String regex = "\\.(jpg|png)";
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        String[] expected = {
                "Paris\\20140101_090000.jpg",
                "Paris\\20140201_121005.jpg",
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_181705.jpg",
                "London\\20140205_090000.jpg",
                "London\\20140205_121005.jpg",
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20150301_120001.png",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(expected, actual);
    }
}