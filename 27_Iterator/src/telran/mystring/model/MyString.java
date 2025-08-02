package telran.mystring.model;

import java.util.Iterator;

public class MyString implements Iterable<Character> {
    private StringBuilder str;

    public void setStr(String str) {
        this.str = new StringBuilder(str);
    }

//    public StringBuilder getStr() {
//        return str;
//    }

    public MyString(String str) {
        this.str = new StringBuilder(str);
    }

    public void accChar(char c) {
        str.append(c);
    }

    @Override
    public String toString() {
        return str + "";
    }

    @Override
    public Iterator<Character> iterator() {
        return new MyStringIterator(str);
    }
}
