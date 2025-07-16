package telran.bitwise.controller;

public class BitwiseAppl {
    public static void main(String[] args) {
        int a = 5;//0101
        int b = 3;//0011

        System.out.println(a & b); //0101 & 0011 -> 0001
        System.out.println(a | b); //0101 | 0011 -> 0111
        System.out.println(~a);// 0101 -> 1010

        System.out.println(b << 2); //0011 -> 0110

        System.out.println(a >> 3);

        byte g = -1; //1111 1111 -> 0111 1111
        System.out.println(g >>> 1);

        int n = 10;
        System.out.println(n % 2 == 0);
        System.out.println((n & 1) == 0); //дает сильный прирост производительности

    }
}
