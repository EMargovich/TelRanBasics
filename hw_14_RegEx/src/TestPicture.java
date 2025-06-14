public class TestPicture {

    public static void main(String[] args) {
        String[] pictureNames = {
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
                "Chicago\\20151111_232000.png"};

        System.out.println("Test 1: All Europe pictures");
        printTestPictures(pictureNames,1);

        System.out.println("Test 2. All autumn pictures");
        printTestPictures(pictureNames,2);

        System.out.println("Test 3. All 2015 spring picture");
        printTestPictures(pictureNames,3);

        System.out.println("Test 4. All night pictures (from 18:00 till 24:00)");
        printTestPictures(pictureNames,4);

        System.out.println("Test 5. All night pictures from Chicago");
        printTestPictures(pictureNames,5);

        System.out.println("Test 6. All jpg and png pictures");
        printTestPictures(pictureNames,6);
    }

    public static boolean testPictureNames(String pictureName, int testNumber) {
        String[] patterns = {
                //Test 1. All Europe pictures
                "(Paris|London)\\\\\\d{4}\\d{2}\\d{2}_\\d{2}\\d{2}\\d{2}.\\w{3}",
                //Test 2. All autumn pictures
                "\\w*\\\\\\d{4}(09|10|11)\\d{2}_\\d{2}\\d{2}\\d{2}.\\w{3}",
                //Test 3  All 2015 spring pictures
                "\\w*\\\\2015(03|04|05)\\d{2}_\\d{2}\\d{2}\\d{2}.\\w{3}",
                //Test 4. * All night pictures (from 18:00 till 24:00)
                "\\w*\\\\\\d{4}\\d{2}\\d{2}_(1[8-9]|2[0-3])\\d{2}\\d{2}.\\w{3}",
                //Test 5. * All night pictures from Chicago
                "Chicago\\\\\\d{4}\\d{2}\\d{2}_(1[8-9]|2[0-3])\\d{2}\\d{2}.\\w{3}",
                //Test 6. * All jpg and png pictures
                "\\w*\\\\\\d{4}\\d{2}\\d{2}_\\d{2}\\d{2}\\d{2}.(jpg|png)"
        };

        if (testNumber >0 && testNumber <=6) {
            return pictureName.matches(patterns[testNumber-1]);
        } else {
            System.out.println("Incorrect test number");
        }
        return false;
    }

    public static void printTestPictures(String[] pictureNames, int testNumber) {
        for (String pictureName : pictureNames) {
            if(testPictureNames(pictureName, testNumber)) {
                System.out.println(pictureName);
            }
        }
        System.out.println();
    }
}
