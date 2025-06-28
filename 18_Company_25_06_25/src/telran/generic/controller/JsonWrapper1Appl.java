package telran.generic.controller;

import telran.generic.model.JsonWrapper1;

public class JsonWrapper1Appl {
    public static void main(String[] args) {
        JsonWrapper1 wrapper1 = new JsonWrapper1(42);
        System.out.println(wrapper1);
        if (wrapper1.getValue() instanceof String) {
            System.out.println((String) wrapper1.getValue() + 5);
        }
        if (wrapper1.getValue() instanceof Integer) {
            System.out.println((Integer) wrapper1.getValue() + 5);
        }
    }
}
