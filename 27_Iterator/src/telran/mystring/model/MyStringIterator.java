package telran.mystring.model;

import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {

    private StringBuilder builder;

    int size ;
    int i;

    public MyStringIterator(StringBuilder builder) {
        this.builder = builder;
        size = builder.length();
        i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < size ? true : false;
    }

    @Override
    public Character next() {
        Character c = builder.charAt(i);
        i++;
        return c;
    }
}
