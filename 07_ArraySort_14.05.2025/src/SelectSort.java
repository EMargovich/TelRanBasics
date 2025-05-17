public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[10];

        System.out.println("Select sort");
        fillArray(arr, 10, 90);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i], indexMin = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min ) {
                    indexMin = j;
                    min = arr[j];
                    }
            }
            arr[indexMin] = arr[i];
            arr[i] = min;
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

}
