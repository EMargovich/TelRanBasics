package telran.mystring;

import telran.mystring.model.MyString;

import java.util.Iterator;

public class MyStringAppl {
    public static void main(String[] args) {
        MyString myString = new MyString("Mama");
        System.out.println(myString);
        myString.accChar('.');
        System.out.println(myString);

        Iterator<Character> iterator = myString.iterator();

        while(iterator.hasNext()) {
            Character c = iterator.next();
            System.out.println(c);
        }
    }
}
