package telran.exception.controller;

import telran.exception.model.AnyNumberException;

import javax.imageio.stream.ImageInputStream;

public class ExceptionAppl {
    public static void main(String[] args){
        int a = 5;
        int b = 0;

        int x = 0;
        try {
            x = solution(a, b);
        } catch (AnyNumberException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime exception: " + e);
        }


        System.out.println("result = " + x);
    }

    private static int solution(int a, int b) throws AnyNumberException{
        if(a == 0 && b == 0) {
            throw new AnyNumberException("Solution any number");
        }
        if(a != 0 && b == 0) {
            throw new RuntimeException("Infinity");
        }
        int res = a / b;
        return res;
    }
}
