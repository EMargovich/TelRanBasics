package telran.equation.controller;

import telran.equation.model.QuadraticEquation;

public class EquationAppl {
    public static void main(String[] args) {
        QuadraticEquation eq = new QuadraticEquation(1, 5, -6);
        eq.display();
        System.out.println("Delta = " + eq.delta());
        System.out.println("Number of roots = " + eq.quantityRoots());

        double[] roots = eq.getRoots();
        for (int i = 0; i < roots.length; i++) {
            System.out.println("root[" + (i + 1) + "] = " + roots[i]);
        }
    }
}

