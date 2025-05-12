public class ArrayAdvAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];
        printArray(arr);
        fillArray(arr, 10 , 99);
        printArray(arr);

        int res = sumArray(arr); //Return aum
        System.out.println("Sum = " + res);
        double avg = average(arr);
        System.out.printf("Avg = %.1f%n", avg);
        res = max(arr);
        System.out.println("Max  = " + res);
        res = search(arr, arr[7]); //Return index first item with value equal item[7]
        String message = res == -1 ? "Value not found" : ("Index = " + res);
        System.out.println(message);
    }

    private static int max(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if(i > max) max = i;
        }
        return max;
    }

    private static int search(int[] arr, int searchVal) {
        int index = -1;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == searchVal) index = j;
        }

        return index;
    }

    private static double average(int[] arr) {
        double average = 0;
        for (int i = 0; i < arr.length ; i++) {
            average += arr[i]*1./(arr.length*1.);
        }
        return average;
    }

    private static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static void fillArray(int[] arr, int from, int to) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (from + Math.random() * ( to - from + 1));
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
