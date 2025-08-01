package telran.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int index = 1;
    private int quantity;
    private int num1 = 0;
    private int num2 = 1;

    public FibonacciIterator(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean hasNext() {
        return index < quantity ? true : false;
    }

    @Override
    public Integer next() {
        int sum = num1 + num2;
        num1 = num2;
        num2 = sum;
        index++;
        return sum;
    }
}
