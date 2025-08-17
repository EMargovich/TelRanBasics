import java.sql.SQLOutput;
import java.util.*;

public class Anagram {

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
        System.out.println(isAnagram("     ", " "));
    }

    public static boolean isAnagram(String word, String anagram) {
        if(word == null || anagram == null)
            return false;
        if(word.isBlank() || anagram.isBlank())
            return false;
        if(anagram.length() > word.length()) //Проверка, не больше ли частное общего
            return false;
        Map<Character,Integer> count = new HashMap<>();
        for(char  ch: word.toCharArray()) {
            count.put(ch, count.getOrDefault(ch,0) + 1);
        }
        for(char ch : anagram.toCharArray()) {
            int c = count.getOrDefault(ch, 0);
            if(c==0) return false;
            count.put(ch,c-1);
        }
        return true;
    }
}
