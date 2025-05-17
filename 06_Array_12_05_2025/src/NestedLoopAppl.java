public class NestedLoopAppl {
    public static void main(String[] args) {
      //  pithagoras();
      //  figure(7);
      //diagonal1(7);
      //diagonal2(7);
      cross(7);
    }

    private static void cross(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i >= n - j + 1 && i >= j) {
                    System.out.print("*  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();

        }
    }

    private static void diagonal2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == n - j + 1) {
                    System.out.print("*  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();

        }
    }

    private static void diagonal1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) {
                    System.out.print("*  ");
                } else {
                    System.out.print("-  ");
                }


            }
            System.out.println();
        }
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
