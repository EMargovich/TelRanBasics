package telran.photoSelector.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {
        public static String[] selectPictures(String[] pictures, String regex) {
                StringBuilder sb = new StringBuilder();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher;
                for(String picture : pictures) {
                        matcher = pattern.matcher(picture);
                        if (matcher.find()) {
                                sb.append(picture);
                                sb.append(",");
                        }
                        //matcher.reset();
                }
                return sb.toString().split(",");
        }
}
