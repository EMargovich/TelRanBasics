public class Homework_04 {
    public static void main(String[] args) {
        double a = 2.8989;
        double b = 80;
        char c = '%';

        double res = calculator(a,b, c);
        System.out.println(a + " " + c + " " + b + " = " + res);
    }

    private static double calculator(double a, double b, char c) {
        Calc func = switch (c) {
          case '+' -> () -> a + b;
          case '-' -> () -> a - b;
          case '/' -> () -> a / b;
          case '*' -> () -> a * b;
          case '^' -> () -> {
              if (b % 1 != 0) {
                  System.out.println("Wrong value of degree!");
                  return 0./0.;
              } else {
                  double pow = 1;
                  for (int i = 0; i < b; i++) {
                      pow = pow * a;
                  }
                  return pow;
              }
          };
          case '%' -> () -> a * b / 100;
          default -> () -> 0;
        };
        return func.func();
    }
}

interface Calc {
    double func();
}

