package telran.memory.utils;

public class MemoryService  {
    public static int getMaxAvailableMemory() {
        int size = 0;
        int right = Integer.MAX_VALUE;
        int left = 0;


        while (size != right - 1) {
            try {
                int[] arr = new int[size];
                left = size;
                size += (right-size)/2;
            } catch (OutOfMemoryError e) {
                right = size;
                size -= (right-left)/2;
            }
        }
        return size;
    }

   }
