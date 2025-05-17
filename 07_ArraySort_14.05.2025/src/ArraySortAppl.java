public class ArraySortAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];
        fillArray(arr, 10, 90);
        printArray(arr);

        bubbleSort1(arr);
        System.out.println();
        printArray(arr);
//
//        bubbleSort1(arr);
//
//        System.out.println(
//        );
//
//        bubbleSort(arr);
        int res = binarySearch(arr, 10);
        System.out.println("Binary search result " + res);

 //

    }
//Homework
    public static void selectSort (int[] arr) {
// Write max number sort (вставкой, мердж, hip)

    }

    private static int binarySearch(int[] arr, int value) {
        int l = 0; //Min left index
        int r = arr.length - 1; //Max right index

        while(l <= r) {
            int mid = (l + r)/2;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] > value)
                r = mid - 1;
            else l = mid + 1;
        }
        return r+1;

    }

    private static void bubbleSort1(int[] arr){

        while(bubbling(arr));

    }

    private static boolean bubbling(int[] arr) {
        System.out.print(" *");
        boolean res = false;
        for (int j = 0; j < arr.length -1; j++) {
            if (arr[j+1] < arr[j]) {
                int temp;
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                res = true;
            }

        }
        return res;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print("* ");
            for (int j = 0; j < arr.length-i-1; j++) {

                if (arr[j+1] < arr[j]) {
                    int temp;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
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

    public static void  reverseArray(int[] arr) {
        for (int i = 0, j = arr.length-1, c; i <= j; i++, j-- ) {
            c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }
}
