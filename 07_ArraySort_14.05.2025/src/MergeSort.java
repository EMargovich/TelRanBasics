public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];

        System.out.println("Select sort");
        fillArray(arr, 10, 90);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    private static void mergeSort(int[] arr) {
        int mid = arr.length/2;
        int mid_value = arr[mid];

        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];
        int arr1End = 0, arr2End = 0;


        for (int i = 0; i < arr.length; i++) {
          //  if
        }


    }

    //Massive get only sorted array
    private static int[] merge(int[] arr1, int[] arr2) {
        int i1 = 0, i2 = 0, iRes = 0;
        int[] arrRes = new int[arr1.length + arr2.length];

        while (i1 < arr1.length || i2 < arr2.length) {
            if (arr1[i1] < arr2 [i2]) {
                arrRes[iRes] = arr1[i1];
                i1++;
            } else {
                arrRes[iRes] = arr2[i2];
                i2++;
            }
            iRes++;
        }
        return arrRes;
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
