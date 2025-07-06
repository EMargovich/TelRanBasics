package telran.multiarray.controller;

import java.util.Timer;

public class interviewTestAppl {
    public static void main(String[] args) {
        int l = 10;

        int[][] arr = new int[l][l];
        long t1 = System.currentTimeMillis();
        fillArray(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        int[][] arr2 = new int[l][l];
        t1 = System.currentTimeMillis();
        fillArray2(arr2);
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void fillArray(int[][] arr) {
        System.out.println("Base fill");

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[0][i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = i * j;
            }
        }

    }

    private static void fillArray2 (int[][] arr) {
        System.out.println("Optimised fill");
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[0][i] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i][i] = i * i;
            for (int j = i + 1; j < arr[i].length; j++) {
                arr[j][i] = i*j;
                arr[i][j] = i*j;
            }
        }
    }
}
