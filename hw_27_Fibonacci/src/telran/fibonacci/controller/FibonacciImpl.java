package telran.fibonacci.controller;

import telran.fibonacci.model.Fibonacci;

import java.util.Iterator;

public class FibonacciImpl {

    public static void main(String[] args) {
        int currentNum;
        int sum = 1;

        Fibonacci fibonacci = new Fibonacci(8);

        Iterator<Integer> iterator = fibonacci.iterator();

        System.out.print("1 ");

        while(iterator.hasNext()) {
            currentNum = iterator.next();
            sum += currentNum;
            System.out.print(currentNum + " ");
        }
        System.out.println("\nSum = " + sum);

    }

}
