package hw_08_QuadraticEquation.src.telran.equation.controller;

import hw_08_QuadraticEquation.src.telran.equation.model.QuadraticEquation;

public class EquationApp {
    public static void main(String[] args) {
        var eq = new QuadraticEquation(2, -4, -6);
        //eq.display();
        System.out.println("Delte = " + eq.delta());
        System.out.println("Number of roots = " + eq.quantityRoots());
        double[] roots = eq.getRoots();
    }

}
