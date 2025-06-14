package telran.regex.controller;

public class RegExAppl {
    public static void main(String[] args) {
        String str = "      Karmiel 1999"; //1990 - 2025
        String pattern = " *[Kk]armiel ?(199[0-9]|20[0-1][0-9]|202[0-5])A?";
        boolean check = str.matches(pattern);
        System.out.println(check);

        String domain = "kuiu.jkjk.ua";
        pattern = "(\\w+\\.ua)|(\\w+\\.\\w+\\.ua)";
        check = domain.matches(pattern);
        System.out.println(check);

        String email = "p-.h@gma8il.kjkcom";
        pattern = "\\w(\\w|\\.|-)*@[a-z]+\\.[a-z]{2,6}";
        check = email.matches(pattern);
        System.out.println(check);
    }
}
