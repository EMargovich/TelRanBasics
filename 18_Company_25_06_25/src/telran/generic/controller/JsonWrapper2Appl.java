package telran.generic.controller;

import telran.generic.model.JsonWrapper2;

public class JsonWrapper2Appl {
    public static void main(String[] args) {
        JsonWrapper2<String> wrapper2 = new JsonWrapper2("100500");

        System.out.println(wrapper2);

        String str = wrapper2.getValue();
        System.out.println(str + 5);
    }
}
