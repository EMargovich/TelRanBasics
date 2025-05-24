package telran.equation.model;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void display(){

        System.out.print(a + "x^2");

        if(b > 0)
            System.out.print("+" + b + "x");
        else if ( b < 0) {
            System.out.print(b + "x");
        }

        if(c > 0)
            System.out.print("+" + c);
        else if (c < 0) {
            System.out.print(c);

        }
        System.out.println("=0");
    }

    private double deltaCalc () {
        return b * b - 4 * a * c;
    }

    public String delta() {
        return String.valueOf(deltaCalc());
    }

    public String quantityRoots() {
        double delta = deltaCalc();
        if (delta > 0 )
            return "2";
        else if (delta == 0)
            return "1";
        else return "0";
    }

    public double[] getRoots() {
        double delta = deltaCalc();
        double[] roots;
        if (delta >= 0) {
            roots = new double[2];
            roots[0] = (-b + Math.sqrt(delta))/(2 * a);
            roots[1] = (-b - Math.sqrt(delta))/(2 * a);
            return roots;
        } else if (delta == 0) {
            roots = new double[1];
            roots[0] = (-b + Math.sqrt(delta))/(2 * a);
            return roots;
        }
        roots = new double[0];
        return roots;    }
}

