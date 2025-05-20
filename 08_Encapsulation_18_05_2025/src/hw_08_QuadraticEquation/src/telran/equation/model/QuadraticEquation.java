package hw_08_QuadraticEquation.src.telran.equation.model;

import java.util.Arrays;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] equation() {
        double[] answers = new double[2];

        double discriminant = b*b - 4 * a * c;

        if (discriminant > 0 ) {
            answers[0] = - b + Math.pow(discriminant,0.5)/(2 * a);
            answers[1] = - b - Math.pow(discriminant,0.5)/(2 * a);

        } else if (discriminant == 0) {
            answers[0] = - b * 2 * a;
            answers[1] = answers[0];
        } else {
            answers[0] = Double.parseDouble(null);
            answers[1] = Double.parseDouble(null);;
        }


        return answers;
    }


}
