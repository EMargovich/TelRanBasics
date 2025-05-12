
public class ArrayAppl {
    public static void main(String[] args) {

        int[] primes = {2, 3, 5, 6};
        System.out.println("Length " + primes.length);
        primes[2] = 10;

        printArray(primes);
    }

    private static void printArray(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            System.out.println("[" + i + "] = " + arr[i] );
        }
    }
}
