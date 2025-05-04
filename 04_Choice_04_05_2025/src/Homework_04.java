public class Homework_04 {
    public static void main(String[] args) {
        double a = 2;
        double b = 0;
        char c = '/';

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
                  return Double.NaN;
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
        return func.calc();
    }
}

interface Calc {
    double calc();
}

