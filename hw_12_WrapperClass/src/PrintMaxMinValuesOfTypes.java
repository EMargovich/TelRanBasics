//Write application for printing minimal/maximal values of the given primitive types
//If the arguments contain wrong type the application should print message: <argument> Wrong type
//Types as String objects should be taken from the arguments of the main function.
//If there is no any type in the arguments the application should print
// maximal/minimal values of 7 types (byte, int, short, long, char, float, double)

public class PrintMaxMinValuesOfTypes {
    public static void main(String[] args) {
        if (args.length == 0) {
            String[] types = {"byte", "int", "short", "long", "char", "float", "double"};
            for (String type : types) {
                printMaxMinOfTypes(type);
            }
        } else {
            for (String type : args) {
                printMaxMinOfTypes(type);
            }
        }
    }

    private static void printMaxMinOfTypes(String type) {

        switch (type) {
            case "byte" ->
                    System.out.println("Type byte: min value " + Byte.MIN_VALUE + ", max value " + Byte.MAX_VALUE);
            case "int" ->
                    System.out.println("Type int: min value " + Integer.MIN_VALUE + ", max value " + Integer.MAX_VALUE);
            case "short" ->
                    System.out.println("Type short: min value " + Short.MIN_VALUE + ", max value " + Short.MAX_VALUE);
            case "long" ->
                    System.out.println("Type long: min value " + Long.MIN_VALUE + ", max value " + Long.MAX_VALUE);
            case "char" ->
                    System.out.println("Type char: min value " + (int) Character.MIN_VALUE + ", max value " + (int) Character.MAX_VALUE);
            case "float" ->
                    System.out.println("Type float: min value " + Float.MIN_VALUE + ", max value " + Float.MAX_VALUE);
            case "double" ->
                    System.out.println("Type double: min value " + Double.MIN_VALUE + ", max value " + Double.MAX_VALUE);
            default ->
                    System.out.println(type + " Wrong type");
        }
    }
}