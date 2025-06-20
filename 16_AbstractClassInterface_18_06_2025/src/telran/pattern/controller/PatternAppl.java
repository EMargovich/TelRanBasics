package telran.pattern.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAppl {
    public static void main(String[] args) {
        String str = "Mama, mula ramy! Mama, mula ramy?";
        String regex = "[Mm]ama";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        System.out.println("Find: " + matcher.find());
        System.out.println("Start: " + matcher.start());
        System.out.println("Group:" + matcher.group());
        System.out.println("End:" + matcher.end());

        System.out.println("==============");

        System.out.println("Find: " + matcher.find());
        System.out.println("Start: " + matcher.start());
        System.out.println("Group:" + matcher.group());
        System.out.println("End:" + matcher.end());

        matcher.reset("Mama mama mula ramu, mama Mama");

        while(matcher.find()) {
            System.out.println("==============");
            System.out.println("Start: " + matcher.start());
            System.out.println("Group:" + matcher.group());
            System.out.println("End:" + matcher.end());
        }
    }
}
