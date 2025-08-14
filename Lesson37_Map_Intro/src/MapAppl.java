import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapAppl {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(7, 2f);
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(0, 11);
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        System.out.println(map);
    }

}
