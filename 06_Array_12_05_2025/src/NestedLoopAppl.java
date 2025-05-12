public class NestedLoopAppl {
    public static void main(String[] args) {
      //  pithagoras();
        figure(7);
    }

    private static void figure(int n) {
        for(int i = 1; i <= n; i++ ) {
            for (int j = 1; j <= n; j++) {
                    if(i > n - j && i >= j) { //Рисуем нижний треугольник
                        System.out.print("*" + "\t");
                    } else if (i <= n - j + 1 && i <= j) { //Рисуем верхний треугольник
                        System.out.print("*" + "\t");
                    } else {
                        System.out.print("-" + "\t");
                    }
            }
            System.out.println();
        }
    }

    private static void pithagoras() {
        for(int i = 1; i <10; i++) {
            for(int j = 1; j < 10; j++ ) {
                System.out.print(i * j + "\t" + "|" + "\t");
            }
            System.out.println();
        }
    }

}
