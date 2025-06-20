package telran.stringbuilder.controller;

public class StringPerformanceTest {
    private static final String WORD = "meow";
    private static final int MAX_ITERATION = 100_000;

    public static void main(String[] args) {

        String str = "";
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITERATION; i++) {
            str += WORD;
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        long t3 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < MAX_ITERATION; i++) {
            sb.append(WORD);
        }
        str = sb.toString();
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }
}
