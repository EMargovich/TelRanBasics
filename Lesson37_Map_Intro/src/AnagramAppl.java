import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class AnagramAppl {
    public static void main(String[] args) {
        String word = "electricity";

        //========True========
        System.out.println("=========true===========");
        System.out.println(isAnagram(word, "electric"));
        System.out.println(isAnagram(word, "city"));
        System.out.println(isAnagram(word, "tric"));
        System.out.println(isAnagram(word, "critic"));

        //=======False=============
        System.out.println("==============false=============");
        System.out.println(isAnagram(word, "ellect"));
        System.out.println(isAnagram(word, "tot"));
        System.out.println(isAnagram(word, "select"));
        System.out.println(isAnagram(word, "teeet"));
        System.out.println(isAnagram(word, " tet"));

    }

    private static boolean isAnagram(String word, String testedWord) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        for (int i = 0; i < testedWord.length(); i++) {
           Character ch = testedWord.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)-1);
           if (map.get(ch) < 0)
               return false;
        }
        return true;
    }


}
